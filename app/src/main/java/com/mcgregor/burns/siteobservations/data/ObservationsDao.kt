package com.mcgregor.burns.siteobservations.data

import androidx.lifecycle.LiveData
import androidx.room.*
import entities.Observation

@Dao
interface ObservationsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(observation:Observation)

    @Query("select * from observations_table")
    fun selectAll(): LiveData<List<Observation>>

    @Query("delete from observations_table")
    fun deleteAll()

    @Delete
    fun delete(observation: Observation)

}