package com.example.nasa.utils

import retrofit2.http.Query

object Utils {
    //    const val API_KEY_DEMO = "DEMO_KEY"
    //    const val API_KEY = "umHEccyxaZnrgViCNbhgb6GcqlNhSkVG3dnVZlmD"
    //    const val API_KEY = "2PMbgpcuwhrOjMEmaXB51xY0SkF50ef2BcX9vPM1"
    //    const val API_KEY = "6L1T3zzftN2g0ZuTgpAVDNBkNojRRDCKjclTONgw"
        const val API_KEY = "RcqebHttpDv9Hh8hABPaQd4b91xHqlZuW18NdTcr"
//    const val API_KEY = "vafhEb6uLSigzudB029f5xyjbtVtzvwpDlGpTczw"
    const val BASE_URL = "https://api.nasa.gov/"
    const val BASE_URL_SEARCH = "https://images-api.nasa.gov/"
    const val CURIOSITY_END_POINT = "mars-photos/api/v1/rovers/curiosity/photos"
    const val CURIOSITY_SOL = 1000
    const val SEARCH_END_POINT = "search"
    var userRequest: String = ""
    var startDate: String = ""
    var endDate: String = ""
    var radioSource: String = "https://www.nasa.gov/multimedia/nasatv/index.html#public"
    var scienceRadioSource: String = "https://onlineradiobox.com/search?cs=us.scifioldtime&played=1&q=science"
    var started: Boolean = false
    var prepared: Boolean = false
    const val APOD_END_POINT = "planetary/apod"

//    "https://api.nasa.gov/planetary/apod?start_date=2022-06-01&end_date=2022-07-01&api_key=RcqebHttpDv9Hh8hABPaQd4b91xHqlZuW18NdTcr"

//    @Query("start_date") startDate: String,
//    @Query("end_date") endDate: String,
//    @Query("api_key") apiKey: String
}