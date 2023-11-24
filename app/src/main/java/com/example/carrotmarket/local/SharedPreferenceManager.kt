package com.example.carrotmarket.local

import android.content.SharedPreferences
import com.example.carrotmarket.ApplicationClass
fun getJwt(): String {
    val prefs: SharedPreferences = ApplicationClass.mSharedPreferences
    return prefs.getString("token", null) ?: ""
}
fun removeJwt() {
    ApplicationClass.mSharedPreferences.edit().apply {
        remove("token")
        apply()
    }
}

fun saveJwt(token: String) {
    ApplicationClass.mSharedPreferences.edit().apply {
        putString("token", token)
        apply()
    }
}
