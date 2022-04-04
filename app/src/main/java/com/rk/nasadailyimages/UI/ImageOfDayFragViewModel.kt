package com.rk.nasadailyimages.UI

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rk.nasadailyimages.Data.DataBaseEntity
import com.rk.nasadailyimages.Data.ImageLoadResult
import com.rk.nasadailyimages.Domain.usecases.ImageRequestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class ImageOfDayFragViewModel:ViewModel() {


    var imageRequestUsecase: ImageRequestUseCase
    val result: MutableLiveData<DataBaseEntity> = MutableLiveData()
    val _result = result

    init {
        imageRequestUsecase = ApplicationClass.instance.getImageRequestUseCase()

        val date = Calendar.getInstance().time

        val format = SimpleDateFormat("yyyy-MM-dd")
       // requestImageOfDay(format.format(date))
        requestImageOfDay("2022-04-03")
    }

    fun requestImageOfDay(date:String) = viewModelScope.launch(Dispatchers.IO){
       val requestResult =  async{
            imageRequestUsecase.getImage(date)
        }
        requestResult.await().let {
            when(it){
                is ImageLoadResult.Success -> {
                    result.postValue(it.response)
                }
            }
        }


    }
}