package com.example.nasa.search.api.model.search

import com.google.gson.annotations.SerializedName

data class MetadataResponse(
    @SerializedName("total_hits")
    val totalHitsResponse: Int?
)
