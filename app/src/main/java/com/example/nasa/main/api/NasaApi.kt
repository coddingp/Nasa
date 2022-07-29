package com.example.nasa.main.api

import com.example.nasa.main.api.model.ApodResponse
import com.example.nasa.utils.Utils.APOD_END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {
    @GET(APOD_END_POINT)
    suspend fun getApodData(
        @Query("api_key") apiKey: String
    ): ApodResponse
}