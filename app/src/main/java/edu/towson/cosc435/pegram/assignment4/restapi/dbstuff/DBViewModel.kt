package edu.towson.cosc435.pegram.assignment4.restapi.dbstuff

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DBViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<Entity>>
    private val repository: Repo

    init {
        val simpleDao = SimpleDatabase.getInstance(application).Dao()
        repository = Repo(Dao = simpleDao)
        readAllData = repository.readAllData
    }

    fun addSample(item: List<Entity>) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSample(item = item)
        }
    }

    fun updateSample(item: Entity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateSample(item)
        }
    }

    fun deleteSample(item: Entity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteSample(item = item)
        }
    }

    fun deleteAllRecord() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllRecord()
        }
    }
}

class DBViewModelFactory(
    private val application: Application
): ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(DBViewModel::class.java)) {
            return DBViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}