package com.example.carrotmarket

import java.io.Serializable

data class Transaction(
    val trans_img : Int,
    val trans_title : String,
    val trans_timeline : String,
    val trans_pos : String,
    val trans_price : String,
    val trans_like_count : Int,
    val trans_comment_count : Int
) : Serializable