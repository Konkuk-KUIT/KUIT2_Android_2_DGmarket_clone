package com.example.carrotmarket.remote

interface SignUpView {
    fun SignUpLoading()
    fun SignUpSuccess()
    fun SignUpFailure(code:Int, msg:String)
}