package com.example.carrotmarket

import android.app.Application
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
//import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationClass : Application() {
    companion object{
        const val DEV_URL : String = "http://13.125.254.172:23899"
        const val PROD_URL : String = "http://kuit_prod_url"

        const val BASE_URL : String = DEV_URL

        lateinit var retrofit : Retrofit
    }

    override fun onCreate() {
        super.onCreate()

        retrofit = Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}