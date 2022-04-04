package com.rk.nasadailyimages.Domain.usecases

import com.rk.nasadailyimages.Data.DataBaseEntity
import com.rk.nasadailyimages.Data.Repository
import javax.inject.Inject

class Savefavoriteitem @Inject constructor(val repository: Repository) {

    fun saveItem(item:DataBaseEntity){
        repository.updateItem(item)
    }
}