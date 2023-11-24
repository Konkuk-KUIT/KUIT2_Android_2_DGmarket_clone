package com.example.carrotmarket.remote

interface UserView {
    fun UserLoading()
    fun UserSuccess(userId: String, nickname: String)
}