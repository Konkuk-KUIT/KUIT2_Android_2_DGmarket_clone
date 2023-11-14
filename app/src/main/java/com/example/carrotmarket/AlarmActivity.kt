package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlarmActivity : AppCompatActivity() {
    //View binding 적용
    lateinit var binding : ActivityAlarmBinding
    private val tablist = arrayListOf("활동 알림", "키워드 알림")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        binding = ActivityAlarmBinding.inflate(layoutInflater)

        initView()

        //기능 추가
        //뒤로 가기 아이콘 선택하면 HomeFragment 페이지로 넘어가도록 설정
        binding.tvAlarmPreviousArrow.setOnClickListener {
            finish()
        }
        setContentView(binding.root)


    }

    private fun initView() {
        binding.alarmMainVp.adapter = AlarmTabLayoutVPAdapter(this)

        TabLayoutMediator(binding.alarmMainTb, binding.alarmMainVp){tab, position ->
            tab.text = tablist[position]

        }.attach()
    }
}