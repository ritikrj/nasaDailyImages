package com.rk.nasadailyimages.Data.Network


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NasaAPI {
    @GET("planetary/apod")
   fun getImageOfDay( @QueryMap query: Map<String,String>): Call<ImageOfDateResponnseModel>
}