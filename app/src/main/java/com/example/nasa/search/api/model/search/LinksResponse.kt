package com.example.nasa.search.api.model.search

import com.google.gson.annotations.SerializedName

data class LinksResponse(
    @SerializedName("href")
    val hrefResponse: String?,
    @SerializedName("prompt")
    val promptResponse: String?,
    @SerializedName("rel")
    val relResponse: String?
)
