package com.example.carrotmarket.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitInterface {
    @POST("users/signup")
    fun signup(
        @Body request: SignupRequest
    ) : Call<BaseResponse<SignupResponse>>
}