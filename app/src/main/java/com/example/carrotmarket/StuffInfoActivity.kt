package com.example.carrotmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    //view binding 적용하고
    lateinit var binding: ActivityStuffInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //back 버튼에 activity 종료 => finish()
        binding.arrow.setOnClickListener {
            finish()
        }
    }
}