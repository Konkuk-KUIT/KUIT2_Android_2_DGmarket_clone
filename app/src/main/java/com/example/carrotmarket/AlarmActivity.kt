package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class AlarmActivity : AppCompatActivity() {
    lateinit var binding : ActivityAlarmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivAlarmBack.setOnClickListener {
            finish()
        }
    }
}