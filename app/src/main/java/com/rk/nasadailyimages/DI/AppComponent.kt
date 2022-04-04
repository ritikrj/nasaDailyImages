package com.rk.nasadailyimages.DI

import com.rk.nasadailyimages.Data.DataBase
import com.rk.nasadailyimages.Domain.usecases.ImageRequestUseCase
import com.rk.nasadailyimages.UI.ApplicationClass
import com.rk.nasadailyimages.UI.ImageOfTheDayFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CommonModule::class])
interface AppComponent {

    fun getImageRequestUseCase():ImageRequestUseCase
    fun getDataBase(): DataBase
}