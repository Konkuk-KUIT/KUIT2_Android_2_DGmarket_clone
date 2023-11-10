package com.example.carrotmarket

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ProductTable")
data class ProductEntity(
    var productImage : Int,
    //drawable 로도 가능은 하지만 int형을 활용
    var productLocation : String,
    var productTitle : String,
    var productPrice : String

) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}
