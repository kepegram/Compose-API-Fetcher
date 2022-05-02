package edu.towson.cosc435.pegram.assignment4.restapi.dbstuff

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {
    @Query("SELECT * FROM SampleData")
    fun getAllData(): LiveData<List<Entity>>

    @Query("SELECT * FROM SampleData WHERE id = :id")
    fun getById(id: Int): Entity

    @Insert
    suspend fun insert(item: List<Entity>)

    @Update
    suspend fun update(item: Entity)

    @Delete
    suspend fun delete(item: Entity)

    @Query("DELETE FROM SampleData")
    suspend fun deleteAllRecord()
}