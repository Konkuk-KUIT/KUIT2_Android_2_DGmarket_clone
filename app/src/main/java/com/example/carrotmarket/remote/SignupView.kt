package com.example.carrotmarket.remote

interface SignupView {
    fun SignupLoading()
    fun SignupSuccess()
    fun SignupFailure(code: Int, msg : String)
}