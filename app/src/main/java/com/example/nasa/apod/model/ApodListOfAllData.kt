package com.example.nasa.apod.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class ApodListOfAllData : Parcelable {
    @Parcelize
    data class ApodListData(
        val apodAllData: List<ApodAllData>
    ) : ApodListOfAllData()

    @Parcelize
    data class ApodAllData(
        val copyright: String?,
        val date: String?,
        val explanation: String?,
        val hdurl: String?,
        val mediaType: String?,
        val serviceVersion: String?,
        val title: String?,
        val url: String?
    ) : ApodListOfAllData()

}
