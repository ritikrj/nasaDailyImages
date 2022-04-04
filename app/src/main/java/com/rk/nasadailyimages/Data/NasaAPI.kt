package com.rk.nasadailyimages.Data

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap
import retrofit2.http.Url

interface NasaAPI {
    @GET("planetary/apod")
   fun getImageOfDay( @QueryMap query: Map<String,String>): Call<ImageOfDateResponnseModel>
}