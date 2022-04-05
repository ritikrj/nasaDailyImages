package com.rk.nasadailyimages.Domain.repo

import com.rk.nasadailyimages.Data.DB.DataBaseEntity
import com.rk.nasadailyimages.Data.Network.ImageLoadResult

interface IRepository {
    suspend fun  loadImageOfTheDay(date:String): ImageLoadResult
    fun updateItem(item: DataBaseEntity)
    fun getFavItemList(): List<DataBaseEntity>
}