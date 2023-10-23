package com.example.carrotmarket

import java.io.Serializable

data class ProductInfo(
    var productImage : Int,
    //drawable 로도 가능은 하지만 int형을 활용
    var productLocation : String,
    var productTitle : String,
    var productPrice : String

) : Serializable
