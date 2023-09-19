package com.example.carrotmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    //View binding 적용
    lateinit var binding : ActivityStuffInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //기능 추가
        //뒤로 가기 아이콘 선택하면 HomeFragment 페이지로 넘어가도록 설정
        binding.tvInfoPreviousArrow.setOnClickListener {
            finish()
        }
    }
}