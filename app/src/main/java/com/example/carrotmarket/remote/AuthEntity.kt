package com.example.carrotmarket.remote

import android.content.SharedPreferences
import com.google.gson.annotations.SerializedName


data class SignUpRequest(
    @SerializedName("userId") val userId : String,
    @SerializedName("password") val password : String,
    @SerializedName("nickname") val nickname : String
)

data class SignUpResponse(
    @SerializedName("userId") val userId: String
)

data class LogInRequest(
    @SerializedName("userId") val userId : String,
    @SerializedName("password") val password : String,
)

data class LogInResponse(
    @SerializedName("nickname") val nickname : String,
    @SerializedName("token") val token : String
)


data class UserResponse(
    @SerializedName("userId") val userId : String,
    @SerializedName("nickname") val nickname: String
)