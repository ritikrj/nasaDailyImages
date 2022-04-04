package com.rk.nasadailyimages.UI

import android.app.Application
import com.rk.nasadailyimages.DI.AppComponent
import com.rk.nasadailyimages.DI.CommonModule
import com.rk.nasadailyimages.DI.DaggerAppComponent

class ApplicationClass: Application() {
    companion object{
        lateinit var  instance: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        instance = DaggerAppComponent.builder().commonModule(CommonModule(this)).build()
    }
}