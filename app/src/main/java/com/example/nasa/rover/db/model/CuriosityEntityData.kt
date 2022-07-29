package com.example.nasa.rover.db.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class CuriosityEntityData(
    @PrimaryKey val curiosityId: Int = 1,
    @ColumnInfo(name = "curiosityPhotos")
    @Embedded
    val curiosityPhotos: List<CuriosityPhotoEntityData>
)