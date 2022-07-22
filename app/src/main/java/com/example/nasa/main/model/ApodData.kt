package com.example.nasa.main.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApodData(
    val copyright: String?,
    val date: String?,
    val explanation: String?,
    val hdurl: String?,
    val mediaType: String?,
    val serviceVersion: String?,
    val title: String?,
    val url: String?
) : Parcelable
