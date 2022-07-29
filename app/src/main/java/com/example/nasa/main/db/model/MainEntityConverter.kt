package com.example.nasa.main.db.model

import com.example.nasa.main.model.ApodData
import timber.log.Timber

object MainEntityConverter {
    fun toDataBase(response: ApodData): MainEntityData =
        MainEntityData(
            copyright = response?.copyright,
            date = response?.date,
            explanation = response?.explanation,
            hdurl = response?.hdurl,
            mediaType = response?.mediaType,
            serviceVersion = response?.serviceVersion,
            title = response?.title,
            url = response?.url
        )


    fun fromDataBase(response: MainEntityData) : ApodData {
        Timber.i("$response")
        return ApodData(
            copyright = response?.copyright,
            date = response?.date,
            explanation = response?.explanation,
            hdurl = response?.hdurl,
            mediaType = response?.mediaType,
            serviceVersion = response?.serviceVersion,
            title = response?.title,
            url = response?.url
        )
    }

}