package com.mcgregor.burns.siteobservations.data

import androidx.annotation.WorkerThread
import entities.Observation

class ObservationRepository(private val dao: ObservationsDao) {

    val observations = dao.selectAll()

    @WorkerThread
    suspend fun insert(observation:Observation){
        dao.insert(observation)
    }

    @WorkerThread
    suspend fun deleteAll(){
        dao.deleteAll()
    }

    @WorkerThread
    suspend fun delete(observation: Observation)
    {
        dao.delete(observation)
    }

}