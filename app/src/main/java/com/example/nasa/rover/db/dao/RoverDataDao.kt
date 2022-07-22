package com.example.nasa.rover.db.dao

//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.example.nasa.rover.db.model.CuriosityEntityData
//import com.example.nasa.rover.db.model.CuriosityPhotoEntityData
//import kotlinx.coroutines.flow.Flow
//
//@Dao
//interface RoverDataDao {
//    @Insert(entity = CuriosityPhotoEntityData::class, onConflict = OnConflictStrategy.IGNORE)
//    fun insertRoverData(data: CuriosityEntityData)
//
//    @Query("SELECT* FROM rover_data")
//    fun getRoverDataFromDb(): Flow<List<CuriosityPhotoEntityData>>
//
//}