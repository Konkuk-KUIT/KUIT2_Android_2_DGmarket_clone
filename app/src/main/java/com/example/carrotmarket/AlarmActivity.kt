package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlarmActivity : AppCompatActivity() {
    lateinit var binding : ActivityAlarmBinding
    private val tabList = arrayListOf("활동 알림","키워드 알림")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        binding.ivBackHome.setOnClickListener {
            initBackHome()
        }

    }

    private fun initView() {
        binding.vpAlarm.adapter = TabLayoutVPAdapter(this)

        TabLayoutMediator(binding.tlAlarm, binding.vpAlarm){ tab, position ->
            tab.text = tabList[position]
        }.attach()
    }

    private fun initBackHome(){
        finish()
    }
}