package com.example.carrotmarket.remote

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("isSuccess") val isSuccess : Boolean,
    @SerializedName("code") val code : Int,
    @SerializedName("message") val message : String,
    @SerializedName("result") val result : T
//    Response body 복붙
//    "isSuccess": true,
//    "code": 201,
//    "message": "요청에 성공하였습니다.",

)
