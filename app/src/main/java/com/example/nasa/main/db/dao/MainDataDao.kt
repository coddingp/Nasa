package com.example.nasa.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nasa.main.db.model.MainEntityData
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDataDao {
    @Insert(entity = MainEntityData::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertAllData(data: List<MainEntityData>)

    @Query("SELECT* FROM main_data")
    fun getAllData(): Flow<List<MainEntityData>>

}