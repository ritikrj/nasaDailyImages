package com.rk.nasadailyimages.Data.Network

import com.rk.nasadailyimages.Data.DB.DataBaseEntity

data class ImageOfDateResponnseModel(
    val copyright: String?,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
)

fun ImageOfDateResponnseModel.toDBEntry(): DataBaseEntity {
    return DataBaseEntity( date = this.date, explanation = this.explanation,
    hdurl = this.hdurl, media_type = this.media_type, service_version = this.service_version, title = this.title,
    url = this.url, isFavourite = false)
}