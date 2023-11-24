package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlarmActivity : AppCompatActivity() {
    lateinit var binding:ActivityAlarmBinding
    private val tabList = arrayListOf("이미지","텍스트")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        binding.backBtn.setOnClickListener{
            finish()
        }
    }

    private fun initView() {
        binding.alarmVp.adapter = TabLayoutVPAdapter(this)
        TabLayoutMediator(binding.alarmTb, binding.alarmVp) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }


}

