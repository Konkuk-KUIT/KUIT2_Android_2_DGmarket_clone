package com.example.carrotmarket

import android.R
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.carrotmarket.databinding.ActivityPostBinding


class PostActivity : AppCompatActivity() {
    lateinit var binding : ActivityPostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)

        init()
        initStatusBar()
        initTopAppBar()
        setContentView(binding.root)
    }


    private fun init(){

        val text = "여기에 물건을 팔 때 텍스트가 입력됩니다.\n"
        val text2 = "여기는 두 번째 문단이 입력됩니다\n"
        var result = ""

        for(i in 0..10){
            result+=text
        }

        result+="\n"

        for(i in 0..10){
            result+=text2
        }

        binding.ttExample.text = result
    }

    private fun initStatusBar(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.statusBarColor = Color.BLUE
            //window.statusBarColor = Color.TRANSPARENT

        }
    }


    private fun initTopAppBar(){

    }
}