package com.example.nasa.main.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.nasa.main.db.model.MainEntityData
import kotlinx.coroutines.flow.Flow

@Dao
interface MainDataDao {
    @Query("SELECT * FROM main_data")
    fun getAllData(): Flow<MainEntityData>

    @Insert(entity = MainEntityData::class, onConflict = OnConflictStrategy.IGNORE)
    fun insertAllData(data: MainEntityData)

    @Query("DELETE FROM main_data")
    fun deleteData()
}