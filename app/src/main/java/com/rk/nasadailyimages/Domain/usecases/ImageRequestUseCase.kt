package com.rk.nasadailyimages.Domain.usecases

import com.rk.nasadailyimages.Data.ImageLoadResult
import com.rk.nasadailyimages.Data.Repository
import javax.inject.Inject

class ImageRequestUseCase @Inject constructor(val repository: Repository){

    suspend fun getImage(date:String):ImageLoadResult{
        return repository.loadImageOfTheDay(date)
    }
}