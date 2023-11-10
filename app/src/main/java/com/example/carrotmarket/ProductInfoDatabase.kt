package com.example.carrotmarket

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductInfoEntity::class],version = 2)
abstract class ProductInfoDatabase : RoomDatabase() {
    abstract fun getProductInfoDAO() : ProductInfoDAO

    companion object {
        var instance : ProductInfoDatabase? = null

        fun getInstance(context : Context) : ProductInfoDatabase {
            if(instance == null) {
                instance = Room.databaseBuilder(context,ProductInfoDatabase::class.java,"productinfo-database")
                    .fallbackToDestructiveMigration().build()
            }

            return instance!!
        }
    }
}