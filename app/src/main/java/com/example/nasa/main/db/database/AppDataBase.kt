package com.example.nasa.main.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nasa.main.db.dao.MainDataDao
import com.example.nasa.main.db.model.MainEntityData

@Database(version = 1, entities = [MainEntityData::class])
abstract class AppDataBase : RoomDatabase() {
    abstract fun mainDao(): MainDataDao
}
