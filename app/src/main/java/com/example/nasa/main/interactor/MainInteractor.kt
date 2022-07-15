package com.example.nasa.main.interactor

import com.example.nasa.main.model.ApodData
import com.example.nasa.main.repository.MainRemoteRepository

class MainInteractor(
    private val remoteRepository: MainRemoteRepository
) {
    suspend fun getApodData(): ApodData = remoteRepository.getApodData()
}