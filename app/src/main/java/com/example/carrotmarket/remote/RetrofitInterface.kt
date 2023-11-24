package com.example.carrotmarket.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitInterface {
    @POST("users/signup")
    fun signup(
        @Body request : SignUpRequest
    ) : Call<BaseResponse<SignUpResponse>>
    //BaseResponse에 T대신 SignUpResponse가 들어간 것 처럼 사용

    @POST("users/login")
    fun login(
        @Body request : LogInRequest
    ) : Call<BaseResponse<LogInResponse>>
    //BaseResponse에 T대신 LogInResponse가 들어간 것 처럼 사용

    @GET("users")
    fun userinfo() : Call<BaseResponse<UserResponse>>

}