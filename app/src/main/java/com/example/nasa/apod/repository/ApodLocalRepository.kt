package com.example.nasa.apod.repository

import com.example.nasa.apod.model.ApodListOfAllData
import com.example.nasa.main.model.ApodData
import kotlinx.coroutines.flow.Flow

interface ApodLocalRepository {
    suspend fun getApodDataFromDb(): Flow<List<ApodListOfAllData.ApodAllData>>
    suspend fun insertApodDataToDb(list: List<ApodListOfAllData.ApodAllData>)
}