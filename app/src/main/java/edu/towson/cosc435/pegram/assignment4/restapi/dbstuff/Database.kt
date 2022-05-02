package edu.towson.cosc435.pegram.assignment4.restapi.dbstuff

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1, exportSchema = false)
abstract class SimpleDatabase: RoomDatabase() {
    abstract fun Dao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: SimpleDatabase? = null

        fun getInstance(context: Context): SimpleDatabase {
            synchronized(this) {
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    SimpleDatabase::class.java,
                    "simple_database"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}