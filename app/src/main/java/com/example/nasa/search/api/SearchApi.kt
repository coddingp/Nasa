package com.example.nasa.search.api

import com.example.nasa.search.api.model.search.SearchResponse
import com.example.nasa.utils.Utils.SEARCH_END_POINT
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET(SEARCH_END_POINT)
    suspend fun getSearchData(
        @Query("q") q: String,
        @Query("page") page: Int
    ): SearchResponse
}