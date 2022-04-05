package com.rk.nasadailyimages.Data.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rk.nasadailyimages.Common.Constants

@Entity(tableName = Constants.IMAGES_TABLE)
class DataBaseEntity (
    @PrimaryKey
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "explanation")
    val explanation: String,
    @ColumnInfo(name = "hdurl")
    val hdurl: String,
    @ColumnInfo(name = "media_type")
    val media_type: String,
    @ColumnInfo(name = "service_version")
    val service_version: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "favourite")
    var isFavourite:Boolean
)