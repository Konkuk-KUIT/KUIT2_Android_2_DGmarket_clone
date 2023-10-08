package com.example.carrotmarket

import android.graphics.drawable.Drawable
import android.icu.number.IntegerWidth
import java.io.Serializable

data class MyProduct(
    val producttitle:String,
    val productregion:String,
    val producttime:String,
    val productprice:String,
    val productcomment:String,
    val productlike:String,
    val productimage: Int
):Serializable
