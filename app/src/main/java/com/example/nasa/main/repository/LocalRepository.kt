package com.example.nasa.main.repository

import com.example.nasa.main.model.ApodData
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    suspend fun getDataFromDb(): Flow<ApodData>
    suspend fun insertAllDataToDb(list: ApodData)
    suspend fun deleteData()
}