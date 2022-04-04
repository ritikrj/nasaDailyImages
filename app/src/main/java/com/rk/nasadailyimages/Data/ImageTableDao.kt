package com.rk.nasadailyimages.Data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ImageTableDao {
   // fun getAllRecords():List<DataBaseEntity>
    @Insert
    fun insert(item:DataBaseEntity)
}