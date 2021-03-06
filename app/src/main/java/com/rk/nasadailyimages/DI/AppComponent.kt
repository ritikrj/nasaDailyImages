package com.rk.nasadailyimages.DI

import com.rk.nasadailyimages.Data.DB.DataBase
import com.rk.nasadailyimages.Domain.usecases.ImageRequestUseCase
import com.rk.nasadailyimages.Domain.usecases.LoadFavImages
import com.rk.nasadailyimages.Domain.usecases.Savefavoriteitem
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CommonModule::class])
interface AppComponent {

    fun getImageRequestUseCase():ImageRequestUseCase
    fun getDataBase(): DataBase
    fun getSaveFavouriteItem(): Savefavoriteitem
    fun getLoadFavItem(): LoadFavImages
}