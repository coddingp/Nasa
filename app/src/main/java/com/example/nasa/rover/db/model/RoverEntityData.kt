package com.example.nasa.rover.db.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class RoverEntityData(
    @ColumnInfo(name = "roverEntityId") val roverEntityId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "landingDate") val landingDate: String,
    @ColumnInfo(name = "launchDate") val launchDate: String,
    @ColumnInfo(name = "status") val status: String
) : Parcelable