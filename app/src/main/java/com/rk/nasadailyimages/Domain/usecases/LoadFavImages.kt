package com.rk.nasadailyimages.Domain.usecases

import com.rk.nasadailyimages.Data.DataBaseEntity
import com.rk.nasadailyimages.Data.Repository
import javax.inject.Inject

class LoadFavImages @Inject constructor(val repository: Repository){
    fun getFavItemList(): List<DataBaseEntity>{
      return  repository.getFavItemList()
    }
}