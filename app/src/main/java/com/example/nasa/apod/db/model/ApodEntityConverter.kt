package com.example.nasa.apod.db.model

import com.example.nasa.apod.model.ApodListOfAllData

object ApodEntityConverter {
    fun toDataBase(response: List<ApodListOfAllData.ApodAllData>): List<ApodEntityData> =
        response.map { main ->
            ApodEntityData(
                copyright = main.copyright,
                date = main.date.toString(),
                explanation = main.explanation,
                hdurl = main.hdurl,
                mediaType = main.mediaType,
                serviceVersion = main.serviceVersion,
                title = main.title,
                url = main.url
            )
        }

    fun fromDataBase(response: List<ApodEntityData>): List<ApodListOfAllData.ApodAllData> {
        val data =
            response.map { main ->
                ApodListOfAllData.ApodAllData(
                    copyright = main.copyright,
                    date = main.date,
                    explanation = main.explanation,
                    hdurl = main.hdurl,
                    mediaType = main.mediaType,
                    serviceVersion = main.serviceVersion,
                    title = main.title,
                    url = main.url
                )
            }
        return data
    }

}