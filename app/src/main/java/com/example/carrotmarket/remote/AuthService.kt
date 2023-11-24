package com.example.carrotmarket.remote

import android.util.Log
import com.example.carrotmarket.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private val authService = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    fun signUp(id: String, pw : String, name : String){
        val request = SignUpRequest(id, pw, name)
        authService.signup(request).enqueue(object : Callback<BaseResponse<SignUpResponse>>{
            override fun onResponse( // http 통신 성공했을때 호출됨
                call: Call<BaseResponse<SignUpResponse>>,
                response: Response<BaseResponse<SignUpResponse>>
            ) {
                Log.d("SignUp Response", response.toString())
            }

            override fun onFailure(call: Call<BaseResponse<SignUpResponse>>, t: Throwable) {
                // http 통신 실패했을때 호출됨
                Log.d("SignUp Failed", t.toString())
            }

        })
    }
}