package com.example.carrotmarket.remote

import android.util.Log
import com.example.carrotmarket.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private val authService = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    private lateinit var signupView : SignupView

    fun setSignupView(signupView : SignupView) {
        this.signupView = signupView
    }

    fun signUp(id: String, pw: String, name: String) {
        signupView.SignupLoading()
        val request = SignupRequest(id,pw,name)
        authService.signup(request).enqueue(object : Callback<BaseResponse<SignupResponse>>{
            override fun onResponse(
                call: Call<BaseResponse<SignupResponse>>,
                response: Response<BaseResponse<SignupResponse>>
            ) {
                val resp = response.body()
                Log.d("Signup response",resp.toString())
                when(resp!!.code) {
                    201 -> signupView.SignupSuccess()
                    else -> signupView.SignupFailure(resp.code,resp.message)
                }
            }

            override fun onFailure(call: Call<BaseResponse<SignupResponse>>, t: Throwable) {
                Log.d("Signup Failed",t.toString())
            }
        })
    }
}