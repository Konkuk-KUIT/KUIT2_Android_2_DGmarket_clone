package com.example.carrotmarket

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDAO{
    @Insert
    fun addProduct(product: ProductEntity)

    @Update
    fun updateProduct(product: ProductEntity)

    @Delete
    fun deleteProduct(product: ProductEntity)

    @Query("SELECT * FROM ProductTable")
    fun getProducts() : List<ProductEntity>

    @Query("SELECT * FROM ProductTable WHERE id=:id")
    fun getProductById(id : Int) : ProductEntity
}