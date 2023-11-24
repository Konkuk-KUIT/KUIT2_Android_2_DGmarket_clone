package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
    lateinit var binding: ActivityPostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.postActivityBtn.setOnClickListener(
//            finish()
//        )
    }

}