package com.example.carrotmarket
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ProductTable")
data class Product(
    val thumbnail : Int,
    val title : String,
    val location : String,
    val time : String,
    val price : Int
):Serializable{
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}