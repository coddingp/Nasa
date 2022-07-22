package com.example.nasa.apod.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nasa.apod.db.model.ApodEntityData
import kotlinx.coroutines.flow.Flow

@Dao
interface ApodDataDao {
    @Insert(entity = ApodEntityData::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertApodData(data: List<ApodEntityData>)

    @Query("SELECT* FROM apod_data")
    fun getApodData(): Flow<List<ApodEntityData>>

}