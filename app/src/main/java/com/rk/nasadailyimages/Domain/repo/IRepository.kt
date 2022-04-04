package com.rk.nasadailyimages.Domain.repo

import com.rk.nasadailyimages.Data.ImageLoadResult

interface IRepository {
    suspend fun  loadImageOfTheDay(date:String): ImageLoadResult
}