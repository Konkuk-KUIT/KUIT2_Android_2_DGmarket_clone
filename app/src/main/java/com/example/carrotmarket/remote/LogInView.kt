package com.example.carrotmarket.remote

interface LogInView {
    fun LogInLoading()
    fun LogInSuccess(nickname: String, token: String)
    fun LogInFailure(code:Int, msg:String)
}