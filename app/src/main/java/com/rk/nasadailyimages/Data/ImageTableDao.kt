package com.rk.nasadailyimages.Data

import androidx.room.*
import com.rk.nasadailyimages.Common.Constants

@Dao
interface ImageTableDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item:DataBaseEntity)

    @Update
    fun update(item:DataBaseEntity)

    @Query("SELECT * FROM "+ "images_table" +" WHERE "+Constants.IMAGE_TABLE_KEY_DATE+" = :fav")
    fun getAllFav(fav:Boolean = true):List<DataBaseEntity>
}