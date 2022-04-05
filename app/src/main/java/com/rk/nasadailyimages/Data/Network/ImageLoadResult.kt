package com.rk.nasadailyimages.Data.Network

import com.rk.nasadailyimages.Data.DB.DataBaseEntity

sealed class ImageLoadResult{

    class Success(val response: DataBaseEntity): ImageLoadResult()
    class Failure(): ImageLoadResult()
}
