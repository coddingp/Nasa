package com.example.nasa.apod.api

import com.example.nasa.apod.api.model.apodList.ApodAllResponse
import com.example.nasa.utils.Utils.APOD_END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodListApi {
    @GET(APOD_END_POINT)
    suspend fun getApodListData(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("api_key") apiKey: String
    ): List<ApodAllResponse>
}