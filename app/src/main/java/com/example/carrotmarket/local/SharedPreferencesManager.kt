package com.example.carrotmarket.local

import com.example.carrotmarket.ApplicationClass

fun getJwt() : String? {
    return ApplicationClass.mSharedPreferences.getString("abcd",null)
}

fun removeJwt() {
    ApplicationClass.mSharedPreferences.edit().clear().apply()
}

fun saveJwt(token : String) {
    ApplicationClass.mSharedPreferences.edit().putString("abcd",token).apply()
}