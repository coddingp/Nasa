package com.example.nasa.main.db.model

import com.example.nasa.apod.db.model.ApodEntityData
import com.example.nasa.main.model.ApodData

object MainEntityConverter {
    fun toDataBase(response: List<ApodData>): List<MainEntityData> =
        response.map { main ->
            MainEntityData(
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

    fun fromDataBase(response: List<MainEntityData>): List<ApodData> {
        val data =
            response.map { main ->
                ApodData(
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