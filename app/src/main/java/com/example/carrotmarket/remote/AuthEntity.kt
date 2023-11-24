package com.example.carrotmarket.remote

import com.google.gson.annotations.SerializedName

data class SignUpRequest( // Request body에 대한 data class
    @SerializedName("userId") val userId : String,
    @SerializedName("password") val password : String,
    @SerializedName("nickname") val nickname : String,

//    "userId" : "kuit@konkuk.ac.kr",
//    "password" : "2023kuit!@#",
//    "nickname" : "yaho"
)

data class SignUpResponse(
    @SerializedName("userId") val userId : String
)
