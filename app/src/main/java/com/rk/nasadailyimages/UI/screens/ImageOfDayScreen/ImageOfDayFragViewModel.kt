package com.rk.nasadailyimages.UI.screens.ImageOfDayScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rk.nasadailyimages.Data.DataBaseEntity
import com.rk.nasadailyimages.Data.ImageLoadResult
import com.rk.nasadailyimages.Domain.usecases.ImageRequestUseCase
import com.rk.nasadailyimages.Domain.usecases.Savefavoriteitem
import com.rk.nasadailyimages.UI.ApplicationClass
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ImageOfDayFragViewModel:ViewModel() {


    var imageRequestUsecase: ImageRequestUseCase
    var savefavoriteItem: Savefavoriteitem
    val result: MutableLiveData<DataBaseEntity> = MutableLiveData()
    val _result = result
    val showToast:MutableLiveData<Boolean> = MutableLiveData()

    init {
        imageRequestUsecase = ApplicationClass.instance.getImageRequestUseCase()
        savefavoriteItem = ApplicationClass.instance.getSaveFavouriteItem()

        val date = Calendar.getInstance().time

        val format = SimpleDateFormat("yyyy-MM-dd")
       // requestImageOfDay(format.format(date))
        requestImageOfDay("2022-04-03")
    }

    fun resetToastFlag(){
        showToast.postValue(false)
    }

    fun requestImageOfDay(date:String) = viewModelScope.launch(Dispatchers.IO){
       val requestResult =  async(Dispatchers.IO){
            imageRequestUsecase.getImage(date)
        }
        requestResult.await().let {
            when(it){
                is ImageLoadResult.Success -> {
                    result.postValue(it.response)
                }
                is ImageLoadResult.Failure -> {
                    showToast.postValue(true)
                }

            }
        }


    }

    fun updateImageOfDayItem(isChecked:Boolean){
        val curr = result.value as DataBaseEntity
        curr.isFavourite = isChecked
        result.postValue(curr)
        savefavoriteItem.saveItem(curr)
    }
}