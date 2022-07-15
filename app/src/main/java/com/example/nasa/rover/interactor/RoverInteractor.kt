package com.example.nasa.rover.interactor

import com.example.nasa.rover.model.RoverData
import com.example.nasa.rover.repository.RoverRemoteRepository

class RoverInteractor(
    private val remoteRepository: RoverRemoteRepository
) {
    suspend fun getRoverData(): List<RoverData.CuriosityPhoto> = remoteRepository.getRoverData()
}