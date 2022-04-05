package com.rk.nasadailyimages.Data.DB

import android.content.Context
import androidx.room.*

@Database(entities = [DataBaseEntity::class], version = 1, exportSchema = false)
abstract class DataBase: RoomDatabase() {
    abstract fun imageTableDao(): ImageTableDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: DataBase? = null

        fun getDatabase(context: Context): DataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DataBase::class.java,
                    "image_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}