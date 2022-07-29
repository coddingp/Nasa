package com.example.nasa.rover.repository

import com.example.nasa.rover.model.RoverData
import kotlinx.coroutines.flow.Flow

interface RoverLocalRepository {
    suspend fun getRoverDataFromDb(): Flow<List<RoverData.CuriosityPhoto>>
    suspend fun insertRoverDataToDb(list: List<RoverData.CuriosityPhoto>)
    suspend fun deleteRoverData()
}