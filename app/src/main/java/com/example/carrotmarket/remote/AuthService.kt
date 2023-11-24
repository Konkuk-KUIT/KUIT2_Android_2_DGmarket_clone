package com.example.carrotmarket.remote

import android.util.Log
import com.example.carrotmarket.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private val authService = ApplicationClass.retrofit.create(RetrofitInterface::class.java)

    private lateinit var signUpView : SignUpView
    private lateinit var logInView : LogInView
    private lateinit var userView : UserView

    fun setSignUpView(signUpView: SignUpView){
        this.signUpView = signUpView
    }

    fun setLogInView(logInView: LogInView){
        this.logInView = logInView
    }

    fun setUserView(userView: UserView){
        this.userView = userView
    }

    fun signUp(id:String, pw:String, name:String){
        signUpView.SignUpLoading()
        val request = SignUpRequest(id, pw, name)
        authService.signup(request).enqueue(object : Callback<BaseResponse<SignUpResponse>>{
            override fun onResponse(
                //통신이 성공했을 때
                call: Call<BaseResponse<SignUpResponse>>,
                response: Response<BaseResponse<SignUpResponse>>
            ) {
                val resp = response.body()
                Log.d("Signup response",resp.toString())
                when(resp!!.code){
                    201 -> signUpView.SignUpSuccess()
                    else -> signUpView.SignUpFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<BaseResponse<SignUpResponse>>, t: Throwable) {
               //통신이 실패했을 때
                Log.d("Signup Failed",t.toString())
            }

        })
        //enqueue가 call / execute
    }

    fun logIn(id:String, pw:String){
        logInView.LogInLoading()
        val request = LogInRequest(id, pw)
        authService.login(request).enqueue(object : Callback<BaseResponse<LogInResponse>>{
            override fun onResponse(
                //통신이 성공했을 때
                call: Call<BaseResponse<LogInResponse>>,
                response: Response<BaseResponse<LogInResponse>>
            ) {
                val resp = response.body()
                Log.d("Login response",resp.toString())
                when(resp!!.code){
                    200 -> logInView.LogInSuccess(resp.result.nickname, resp.result.token)
                    else -> logInView.LogInFailure(resp.code, resp.message)
                }
            }

            override fun onFailure(call: Call<BaseResponse<LogInResponse>>, t: Throwable) {
                //통신이 실패했을 때
                Log.d("Login Failed",t.toString())
            }

        })
        //enqueue가 call / execute
    }

    fun userInfo(){
        userView.UserLoading()
        authService.userinfo().enqueue(object : Callback<BaseResponse<UserResponse>>{
            override fun onResponse(
                //통신이 성공했을 때
                call: Call<BaseResponse<UserResponse>>,
                response: Response<BaseResponse<UserResponse>>
            ) {
                Log.d("response", response.toString())
                //isSuccessful 항상 확인하기
                if(response.isSuccessful) {
                    val resp = response.body()
                    Log.d("User Response Body", resp.toString())
                    Log.d("User response Body result", resp?.result.toString())
                    when(resp!!.code){
                        200 -> userView.UserSuccess(resp.result.userId, resp.result.nickname)
                    }
                }
            }

            override fun onFailure(call: Call<BaseResponse<UserResponse>>, t: Throwable) {
                //통신이 실패했을 때
                Log.d("User Failed","User Failed")
            }

        })
        //enqueue가 call / execute
    }
}