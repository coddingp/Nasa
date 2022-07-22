package com.example.nasa.main.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nasa.apod.db.model.ApodEntityData
import com.example.nasa.main.db.dao.MainDataDao
import com.example.nasa.main.db.model.MainEntityData

@Database(entities = [MainEntityData::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun mainDao(): MainDataDao
}
