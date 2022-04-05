package com.rk.nasadailyimages.DI

import android.content.Context
import com.rk.nasadailyimages.Common.Constants
import com.rk.nasadailyimages.Data.DB.DataBase
import com.rk.nasadailyimages.Data.Network.NasaAPI
import com.rk.nasadailyimages.Data.Repository
import com.rk.nasadailyimages.Domain.repo.IRepository
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class CommonModule(val applicationContext: Context) {


    @Provides
    @Singleton
    fun getRetrofitInstance(): Retrofit {
      return  Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .client(OkHttpClient()).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun getNasaApi(retrofit: Retrofit): NasaAPI {
        return retrofit.create(NasaAPI::class.java)
    }

    @Provides
    @Singleton
    fun getImageDB(): DataBase {
       return DataBase.getDatabase(applicationContext)
    }
    @Provides
    @Singleton
    fun getRepository(repository: Repository):IRepository{
        return repository
    }


}