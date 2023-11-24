package com.example.carrotmarket

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version = 3)
abstract class ProductDB : RoomDatabase(){
    abstract fun getProductDAO() : ProductDAO

    companion object{
        var instance : ProductDB? = null

        fun getInstance(context: Context) : ProductDB {
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDB::class.java,
                    "product-database"
                ).fallbackToDestructiveMigration().build()
            }
            return instance!!
        }
    }
}
