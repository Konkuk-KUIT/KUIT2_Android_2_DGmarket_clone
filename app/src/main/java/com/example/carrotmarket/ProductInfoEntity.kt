package com.example.carrotmarket

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "ProductInfoTable")
data class ProductInfoEntity(
    val trans_img : Int,
    val trans_title : String,
    val trans_timeline : String,
    val trans_pos : String,
    val trans_price : String,
    val trans_like_count : Int,
    val trans_comment_count : Int
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}