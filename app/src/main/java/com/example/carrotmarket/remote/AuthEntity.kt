package com.example.carrotmarket.remote

import com.google.gson.annotations.SerializedName

data class SignupRequest(
    @SerializedName("userId") val userId : String,
    @SerializedName("password") val password : String,
    @SerializedName("nickname") val nickname : String
)

data class SignupResponse(
    @SerializedName("userId") val userId : String
)