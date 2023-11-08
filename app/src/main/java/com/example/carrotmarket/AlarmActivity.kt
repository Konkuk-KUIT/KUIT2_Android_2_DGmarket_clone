package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlarmActivity : AppCompatActivity() {
    lateinit var binding: ActivityAlarmBinding
    private var tabList = arrayListOf("활동 알림","키워드 알림")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        binding.back.setOnClickListener {
            finish()
        }
    }

    private fun initView() {
        binding.mainVp.adapter = TabLayoutVPAdapter(this)

        TabLayoutMediator(binding.mainTb,binding.mainVp){tab,position->
            tab.text=tabList[position]
        }.attach()
    }
}