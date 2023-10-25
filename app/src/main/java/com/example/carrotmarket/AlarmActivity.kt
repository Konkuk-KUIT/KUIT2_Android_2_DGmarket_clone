package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlarmActivity : AppCompatActivity() {
    lateinit var binding : ActivityAlarmBinding
    private val alarmList = mutableListOf<String>()
    private val tabList = arrayListOf("활동 알림","키워드 알림")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initDummyData()
        //initViewPager()

        initView()

        binding.ivAlarmBack.setOnClickListener {
            finish()
        }

        //supportFragmentManager.beginTransaction().replace(R.id.frm_alarm_list,ActiveAlarmFragment()).commit()
    }

    private fun initView() {
        binding.alarmAreaVp.adapter = AlarmSliderVPAdapter(this)

        TabLayoutMediator(binding.alarmTab,binding.alarmAreaVp) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }

    /*private fun initViewPager() {
        binding.alarmAreaVp.adapter = AlarmSliderVPAdapter(applicationContext,alarmList)
        binding.alarmAreaVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        setFragmentChangeEvent()
    }

    private fun setFragmentChangeEvent() {
        binding.alarmAreaVp.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {

            }
        })
    }

    private fun initDummyData() {

    }*/
}