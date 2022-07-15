package com.example.nasa.apod.model

import com.example.nasa.apod.api.model.apodList.ApodAllResponse

object ApodListConverter {

    fun fromNetWork(response: List<ApodAllResponse>) =
        response.map {
            ApodListOfAllData.ApodAllData(
                copyright = it?.copyright,
                date = it?.date,
                explanation = it?.explanation,
                hdurl = it?.hdurl,
                mediaType = it?.mediaType,
                serviceVersion = it?.serviceVersion,
                title = it?.title,
                url = it?.url
            )
        }
}