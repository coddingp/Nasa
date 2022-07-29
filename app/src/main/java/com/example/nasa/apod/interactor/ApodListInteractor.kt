package com.example.nasa.apod.interactor

import com.example.nasa.apod.model.ApodListOfAllData
import com.example.nasa.apod.repository.ApodListRemoteRepository

class ApodListInteractor(
    private val remoteRepository: ApodListRemoteRepository
) {
    suspend fun getApodListData(): List<ApodListOfAllData.ApodAllData> =
        remoteRepository.getApodListData()
}