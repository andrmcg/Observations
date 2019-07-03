package com.mcgregor.burns.siteobservations.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import entities.Observation

@Dao
interface ObservationsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(observation:Observation)

    @Query("select * from observations_table")
    fun selectAll(): LiveData<List<Observation>>

}