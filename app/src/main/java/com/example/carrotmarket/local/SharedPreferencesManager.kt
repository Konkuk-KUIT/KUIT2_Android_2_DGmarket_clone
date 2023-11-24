package com.example.carrotmarket.local

import com.example.carrotmarket.ApplicationClass

fun getJwt() : String? {
    return ApplicationClass.mSharedPreferences.getString()
}

fun removeJwt() {
    ApplicationClass.mSharedPreferences.edit().clear().apply()
}

fun saveJwt() {
    ApplicationClass.mSharedPreferences.edit().putString()
}