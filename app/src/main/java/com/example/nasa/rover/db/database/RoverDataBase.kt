package com.example.nasa.rover.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nasa.rover.db.dao.RoverDataDao
import com.example.nasa.rover.db.model.CuriosityPhotoEntityData

@Database(entities = [CuriosityPhotoEntityData::class], version = 1)
abstract class RoverDataBase : RoomDatabase() {
    abstract fun roverDao(): RoverDataDao
}
