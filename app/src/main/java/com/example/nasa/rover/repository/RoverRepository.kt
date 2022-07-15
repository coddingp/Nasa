package com.example.nasa.rover.repository

import com.example.nasa.rover.model.RoverData

interface RoverRepository {
    suspend fun getRoverData(): List<RoverData.CuriosityPhoto>
}