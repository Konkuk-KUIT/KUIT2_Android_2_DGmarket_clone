package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.carrotmarket.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {
    lateinit var binding : ActivityAlarmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)

        supportFragmentManager.beginTransaction().replace(R.id.fl_notify_contents,NotifyFragment()).commit()
        // replace() 인자값은 int형으로 넣어야하기 때문에 r.id.id값으로 넣어야함
        // view 객체를 가져오기 때문에 형이 맞지 않음 -> r.id.으로 구현
        binding.ivBackHome.setOnClickListener {
            initBackHome()
        }

        binding.clActivityNotify.setOnClickListener{
            initActivity()
        }

        binding.clKeywordNotify.setOnClickListener {
            initKeyWord()
        }
        setContentView(binding.root)
    }

    private fun initBackHome(){
        finish()
    }

    private fun initActivity(){
        supportFragmentManager.beginTransaction().replace(R.id.fl_notify_contents,NotifyFragment()).commit()
        binding.viewLine1.visibility = View.VISIBLE
        binding.viewLine2.visibility = View.INVISIBLE
    }

    private fun initKeyWord(){
        supportFragmentManager.beginTransaction().replace(R.id.fl_notify_contents,KeyWordFragment()).commit()
        binding.viewLine1.visibility = View.INVISIBLE
        binding.viewLine2.visibility = View.VISIBLE
    }
}