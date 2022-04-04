package com.rk.nasadailyimages.Data

sealed class ImageLoadResult{

    class Success(val response:DataBaseEntity): ImageLoadResult()
    class Failure(): ImageLoadResult()
}
