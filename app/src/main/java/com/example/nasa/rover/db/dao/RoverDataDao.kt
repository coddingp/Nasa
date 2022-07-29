package com.example.nasa.rover.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nasa.rover.db.model.CuriosityPhotoEntityData
import kotlinx.coroutines.flow.Flow

@Dao
interface RoverDataDao {
    @Query("SELECT * FROM curiosity_photo_data")
    fun getRoverDataFromDb(): Flow<List<CuriosityPhotoEntityData>>

    @Insert(entity = CuriosityPhotoEntityData::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertRoverData(data: List<CuriosityPhotoEntityData>)

    @Query("DELETE FROM curiosity_photo_data")
    fun deleteRoverData()
}