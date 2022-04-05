package com.rk.nasadailyimages.Domain.usecases

import com.rk.nasadailyimages.Data.DB.DataBaseEntity
import com.rk.nasadailyimages.Domain.repo.IRepository
import javax.inject.Inject

class LoadFavImages @Inject constructor(val repository: IRepository){
    fun getFavItemList(): List<DataBaseEntity>{
      return  repository.getFavItemList()
    }
}