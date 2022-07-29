package com.example.nasa.main.interactor

import com.example.nasa.main.model.ApodData
import com.example.nasa.main.repository.MainLocalRepository
import com.example.nasa.main.repository.MainRemoteRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class MainInteractor(
    private val remoteRepository: MainRemoteRepository,
    private val localRepository: MainLocalRepository
) {
    suspend fun getApodDataFromDb(): Flow<ApodData> {
        return localRepository.getDataFromDb()
    }

    suspend fun insertApodDataToDb() {
        val apodData = remoteRepository.getApodData()
        Timber.i("$apodData")
        localRepository.insertAllDataToDb(apodData)
    }

    suspend fun deleteData() {
        localRepository.deleteData()
    }
}