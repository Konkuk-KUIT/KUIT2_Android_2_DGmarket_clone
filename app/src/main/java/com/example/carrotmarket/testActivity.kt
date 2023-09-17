package com.example.carrotmarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.example.carrotmarket.databinding.FragmentMypageBinding

class testActivity : AppCompatActivity(){
    lateinit var binding : FragmentMypageBinding // 원래 네이밍은 Activity가 정확함
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentMypageBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}