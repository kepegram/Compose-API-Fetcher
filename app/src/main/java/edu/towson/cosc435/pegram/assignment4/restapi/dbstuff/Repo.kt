package edu.towson.cosc435.pegram.assignment4.restapi.dbstuff

import androidx.lifecycle.LiveData

class Repo(private val Dao: Dao) {
    val readAllData: LiveData<List<Entity>> = Dao.getAllData()

    suspend fun addSample(item: List<Entity>) {
        Dao.insert(item)
    }

    suspend fun updateSample(item: Entity) {
        Dao.update(item)
    }

    suspend fun deleteSample(item: Entity) {
        Dao.delete(item)
    }

    suspend fun deleteAllRecord() {
        Dao.deleteAllRecord()
    }
}