package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.setViewTreeOnBackPressedDispatcherOwner
import com.example.carrotmarket.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {
    lateinit var binding : ActivityAlarmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().replace(R.id.fl_notify_contents, ActivityNotify()).commit()

        binding.clActiviyNotify.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fl_notify_contents, ActivityNotify()).commit()
            binding.viewLine1.setBackgroundResource(R.color.black)
            binding.viewLine2.setBackgroundResource(R.color.gray)
        }

        binding.clKeywordNotify.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fl_notify_contents, KeywordNotify()).commit()
            binding.viewLine1.setBackgroundResource(R.color.gray)
            binding.viewLine2.setBackgroundResource(R.color.black)
        }

        binding.btnPrevious.setOnClickListener {
            finish()
        }
    }
}