package com.rk.nasadailyimages.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rk.nasadailyimages.Data.DataBaseEntity
import com.rk.nasadailyimages.Domain.usecases.LoadFavImages

class FavoriteImagesViewModel: ViewModel() {
    var loadFavImages:LoadFavImages
    val _result : MutableLiveData<List<DataBaseEntity>> = MutableLiveData()
    val result : LiveData<List<DataBaseEntity>>  = _result
    init {
        loadFavImages = ApplicationClass.instance.getLoadFavItem()
    }

    fun loadFavImageList(){
       _result.postValue( loadFavImages.getFavItemList())
    }

}