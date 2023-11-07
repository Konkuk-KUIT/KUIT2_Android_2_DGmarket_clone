package com.example.carrotmarket

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface MyProductDAO {
    @Insert
    fun addMyProduct(myProduct: MyProduct)

    @Update
    fun updateMyProduct(myProduct: MyProduct)

    @Delete
    fun deleteMyProduct(myProduct: MyProduct)

    @Query("SELECT * FROM MyProductTable")
    fun getMyProducts() : List<MyProduct>
}