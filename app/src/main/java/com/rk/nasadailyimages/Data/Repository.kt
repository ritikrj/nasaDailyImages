package com.rk.nasadailyimages.Data

import android.util.Log
import com.rk.nasadailyimages.Domain.repo.IRepository
import com.rk.nasadailyimages.UI.ApplicationClass
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(val imageOfDayApi:NasaAPI, val db:DataBase):IRepository {


    override suspend fun  loadImageOfTheDay(date:String):ImageLoadResult = suspendCancellableCoroutine<ImageLoadResult>{
      if(db.imageTableDao().exists(date))
      {
          it.resume(ImageLoadResult.Success(db.imageTableDao().get(date)),null)
          return@suspendCancellableCoroutine
      }
      val query:HashMap<String, String> = HashMap()
        Log.d("${this.javaClass} "," requesting "+date)
        query["date"] = date
        query["api_key"] = "mDzKqfqvvOKvSq2AFzZoCQJo4kkVNfMtwMNE3XdR"
        imageOfDayApi.getImageOfDay(query).enqueue(object :Callback<ImageOfDateResponnseModel>{
            override fun onResponse(
                call: Call<ImageOfDateResponnseModel>?,
                response: Response<ImageOfDateResponnseModel>?
            ) {

                Log.d("${this.javaClass} "," Success "+response?.body().toString())

                    response?.body()?.let {
                        ApplicationClass.instance.getDataBase().imageTableDao().insert((response?.body() as ImageOfDateResponnseModel ).toDBEntry())

                    } ?:run{
                        it.resume(ImageLoadResult.Failure(), null)
                    }
                //  ApplicationClass.instance.getDataBase().imageTableDao().insert((response?.body() as ImageOfDateResponnseModel ).toDBEntry())
                if(response?.body() != null)
                it.resume(ImageLoadResult.Success((response?.body() as ImageOfDateResponnseModel ).toDBEntry() ),null)
            }

            override fun onFailure(call: Call<ImageOfDateResponnseModel>?, t: Throwable?) {
                Log.d("${this.javaClass}","Failure "+t.toString())
                it.resume(ImageLoadResult.Failure(), null)
            }

        })

    }


    override fun updateItem(item: DataBaseEntity) {
        db.imageTableDao().update(item)
    }

    override fun getFavItemList(): List<DataBaseEntity> {
       return db.imageTableDao().getAllFav().filter { it.isFavourite }
    }


}