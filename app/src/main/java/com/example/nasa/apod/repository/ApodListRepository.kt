package com.example.nasa.apod.repository

import com.example.nasa.apod.model.ApodListOfAllData

interface ApodListRepository {
    suspend fun getApodListData(): List<ApodListOfAllData.ApodAllData?>
}