package com.example.nasa.search.api.model.search

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("collection")
    val collection: SubResponse?,
    @SerializedName("reason")
    val reasonResponse: String?
)
