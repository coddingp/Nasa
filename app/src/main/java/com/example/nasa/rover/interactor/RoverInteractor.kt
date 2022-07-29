package com.example.nasa.rover.interactor

import com.example.nasa.rover.model.RoverData
import com.example.nasa.rover.repository.MainRoverLocalRepository
import com.example.nasa.rover.repository.RoverRemoteRepository
import kotlinx.coroutines.flow.Flow
import timber.log.Timber

class RoverInteractor(
    private val remoteRepository: RoverRemoteRepository,
    private val localRepository: MainRoverLocalRepository
) {
    suspend fun getRoverDataFromDb(): Flow<List<RoverData.CuriosityPhoto>> =
        localRepository.getRoverDataFromDb()

    suspend fun insertRoverDataToDb(page: Int) {
        val roverData = remoteRepository.getRoverData(page)
        Timber.i("RoverInteractor insertRoverDataToDb $roverData")
        localRepository.insertRoverDataToDb(roverData)
    }

    suspend fun deleteRoverData() {
        localRepository.deleteRoverData()
    }
}