package com.example.nasa.main.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "main_data")
data class MainEntityData(
    @PrimaryKey val id: Int = 1,
    @ColumnInfo(name = "copyright")
    val copyright: String?,
    @ColumnInfo(name = "date")
    val date: String?,
    @ColumnInfo(name = "explanation")
    val explanation: String?,
    @ColumnInfo(name = "hdurl")
    val hdurl: String?,
    @ColumnInfo(name = "mediaType")
    val mediaType: String?,
    @ColumnInfo(name = "serviceVersion")
    val serviceVersion: String?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "url")
    val url: String?,
)