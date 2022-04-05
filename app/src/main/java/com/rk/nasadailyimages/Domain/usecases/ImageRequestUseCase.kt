package com.rk.nasadailyimages.Domain.usecases

import com.rk.nasadailyimages.Data.Network.ImageLoadResult
import com.rk.nasadailyimages.Domain.repo.IRepository
import javax.inject.Inject

class ImageRequestUseCase @Inject constructor(val repository: IRepository){

    suspend fun getImage(date:String): ImageLoadResult {
        return repository.loadImageOfTheDay(date)
    }
}