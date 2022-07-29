package com.example.nasa.rover.db.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "curiosity_photo_data", primaryKeys = ["photoId"])
data class CuriosityPhotoEntityData(
    @ColumnInfo(name = "photoId") val photoId: Int,
    @ColumnInfo(name = "sol") val sol: Int,
    @Embedded
    val camera: CuriosityCameraEntityData,
    @ColumnInfo(name = "imgSrc") val imgSrc: String,
    @ColumnInfo(name = "earthDate") val earthDate: String,
    @Embedded
    val rover: RoverEntityData
) : Parcelable