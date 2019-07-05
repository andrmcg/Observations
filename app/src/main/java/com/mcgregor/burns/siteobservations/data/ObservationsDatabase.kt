package com.mcgregor.burns.siteobservations.data

import android.content.Context
import android.database.sqlite.SQLiteException
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mcgregor.burns.siteobservations.Severity
import entities.Observation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Observation::class], version = 1)
abstract class ObservationsDatabase : RoomDatabase() {

    abstract fun dao(): ObservationsDao

    companion object {
        @Volatile
        private var INSTANCE: ObservationsDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ObservationsDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance =
                    Room.databaseBuilder(context.applicationContext, ObservationsDatabase::class.java, "Club_database")
                        .addCallback(ObservationDatabaseCallback(scope, context))
                        .fallbackToDestructiveMigration()
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class ObservationDatabaseCallback(private val scope: CoroutineScope, context: Context) :
        RoomDatabase.Callback() {
        var ctx = context

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            try {
                if (db.query("select * from observations_table").count <= 0) {
                    INSTANCE?.let { database ->
                        scope.launch(Dispatchers.IO) {
                            populateDatabase(database.dao(), ctx)
                        }
                    }
                }
            } catch (e: SQLiteException) {
            } finally {

            }
        }

        private fun populateDatabase(dao: ObservationsDao, ctx: Context) {

            //TODO code to poulate database
            //var ob = Observation("Groundworker","Akela","Shite",Severity.High.name, "Poor","Get Rid")
            //dao.insert(ob)

        }

    }

}