package com.example.nasa.main.model

import com.example.nasa.main.api.model.ApodResponse

object ApodConverter {

    fun fromNetWork(response: ApodResponse) =
        ApodData(
            copyright = response?.copyright,
            date = response.date,
            explanation = response?.explanation,
            hdurl = response?.hdurl,
            mediaType = response?.mediaType,
            serviceVersion = response?.serviceVersion,
            title = response?.title,
            url = response?.url
        )
}