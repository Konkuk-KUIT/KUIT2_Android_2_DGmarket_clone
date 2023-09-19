package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityStuffinfoBinding

class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding : ActivityStuffinfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPrevious.setOnClickListener {
            finish()
        }

    }
}