package com.mcgregor.burns.siteobservations.data

import androidx.room.Database
import androidx.room.RoomDatabase
import entities.Issue
import entities.Observation
import entities.SubContract
import entities.Trade

@Database(entities = [Observation::class, Trade::class, SubContract::class, Issue::class], version = 1)
abstract class ObservationsDatabase : RoomDatabase() {


}