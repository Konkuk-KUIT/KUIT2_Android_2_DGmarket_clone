package com.example.carrotmarket

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "MyProductTable")
data class MyProduct(
    val producttitle:String,
    val productregion:String,
    val producttime:String,
    val productprice:String,
    val productcomment:String,
    val productlike:String,
    val productimage: Int
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}
