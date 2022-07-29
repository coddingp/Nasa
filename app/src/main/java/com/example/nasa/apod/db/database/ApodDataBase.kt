package com.example.nasa.apod.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nasa.apod.db.dao.ApodDataDao
import com.example.nasa.apod.db.model.ApodEntityData

@Database(entities = [ApodEntityData::class], version = 1, exportSchema = false)
abstract class ApodDataBase : RoomDatabase() {
    abstract fun apodDao(): ApodDataDao
}