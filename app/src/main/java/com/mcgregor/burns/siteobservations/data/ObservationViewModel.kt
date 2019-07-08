package com.mcgregor.burns.siteobservations.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import entities.Observation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ObservationViewModel(application:Application): AndroidViewModel(application) {

    private val repository:ObservationRepository
    val observations:LiveData<List<Observation>>

    private val parentJob = Job()
    private val coroutineContext:CoroutineContext
    get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    init {
        val dao = ObservationsDatabase.getDatabase(application,scope).dao()
        repository = ObservationRepository(dao)
        observations = repository.observations
    }

    fun insert(observation: Observation) = scope.launch(Dispatchers.IO){
        repository.insert(observation)
    }

    fun deleteAll() = scope.launch(Dispatchers.IO){
        repository.deleteAll()
    }

    fun delete(observation: Observation) = scope.launch(Dispatchers.IO){
        repository.delete(observation)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }

}