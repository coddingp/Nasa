package com.example.nasa.rover.repository

import com.example.nasa.rover.api.RoverApi
import com.example.nasa.rover.model.RoverConverter
import com.example.nasa.rover.model.RoverData
import com.example.nasa.utils.Utils.API_KEY
import com.example.nasa.utils.Utils.CURIOSITY_SOL

class RoverRemoteRepository(
    private val api: RoverApi
) : RoverRepository {
    override suspend fun getRoverData(page: Int): List<RoverData.CuriosityPhoto> {
        val roverData = api.getRoverData(CURIOSITY_SOL, page, API_KEY)
        return RoverConverter.fromNetWork(roverData)
    }
}