package com.example.carrotmarket

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyProduct::class], version = 1)
abstract class MyProductDatabase : RoomDatabase() {
    abstract fun getMyProductDAO() : MyProductDAO
    companion object{
        var instance : MyProductDatabase? = null
        fun getInstance(context: Context) : MyProductDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyProductDatabase::class.java,
                    "myproduct-database"
                ).fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }

    }
}