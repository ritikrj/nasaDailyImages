package com.rk.nasadailyimages.Data.DB

import androidx.room.*
import com.rk.nasadailyimages.Common.Constants
import com.rk.nasadailyimages.Data.DB.DataBaseEntity

@Dao
interface ImageTableDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: DataBaseEntity)

    @Update
    fun update(item: DataBaseEntity)

    @Query("SELECT * FROM "+ "images_table")
    fun getAllFav():List<DataBaseEntity>

    @Query("SELECT EXISTS (SELECT 1 FROM images_table WHERE date = :query)")
    fun exists(query: String): Boolean

    @Query("SELECT * FROM "+ "images_table" +" WHERE "+Constants.IMAGE_TABLE_KEY_DATE+" = :query")
   fun get(query: String): DataBaseEntity
}