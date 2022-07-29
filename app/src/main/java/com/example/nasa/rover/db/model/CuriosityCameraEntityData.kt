package com.example.nasa.rover.db.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.parcelize.Parcelize


@Parcelize
data class CuriosityCameraEntityData(
    @ColumnInfo(name = "cameraId") val cameraId: Int,
    @ColumnInfo(name = "cameraName") val cameraName: String,
    @ColumnInfo(name = "roverId") val roverId: Int,
    @ColumnInfo(name = "fullName") val fullName: String
) : Parcelable