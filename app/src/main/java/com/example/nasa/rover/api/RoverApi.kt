package com.example.nasa.rover.api

import com.example.nasa.rover.api.model.CuriosityResponse
import com.example.nasa.utils.Utils.CURIOSITY_END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface RoverApi {
    @GET(CURIOSITY_END_POINT)
    suspend fun getRoverData(
        @Query("sol") sol: Int,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String
    ): CuriosityResponse
}