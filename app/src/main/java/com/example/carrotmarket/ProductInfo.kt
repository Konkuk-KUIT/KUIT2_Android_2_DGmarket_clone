package com.example.carrotmarket

import java.io.Serializable

data class ProductInfo(
    var productImage : Int,
    var productLocation : String,
    var productTitle : String,
    var productPrice : String

) : Serializable
