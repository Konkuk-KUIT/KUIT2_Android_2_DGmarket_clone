package com.example.carrotmarket

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductInfoDAO {
    @Insert
    fun addProductInfo(myProductInfo : ProductInfoEntity)

    @Update
    fun updateProductInfo(myProductInfo: ProductInfoEntity)

    @Delete
    fun DeleteProductInfo(myProductInfo: ProductInfoEntity)

    @Query("SELECT * FROM ProductInfoTable")
    fun getAllProductInfo() : List<ProductInfoEntity>
}