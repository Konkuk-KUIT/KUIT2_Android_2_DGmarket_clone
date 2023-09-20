package com.example.carrotmarket

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.carrotmarket.databinding.ActivityAlarmBinding

class AlarmActivity : AppCompatActivity() {
    lateinit var binding : ActivityAlarmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)

        supportFragmentManager.beginTransaction().replace(R.id.fl_notify_contents,NotifyFragment())

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
        supportFragmentManager.beginTransaction().replace(R.id.fl_notify_contents,NotifyFragment())
        binding.viewLine1.visibility = View.VISIBLE
        binding.viewLine2.visibility = View.INVISIBLE
    }

    private fun initKeyWord(){
        supportFragmentManager.beginTransaction().replace(R.id.fl_notify_contents,KeyWordFragment())
        binding.viewLine1.visibility = View.INVISIBLE
        binding.viewLine2.visibility = View.VISIBLE
    }
}