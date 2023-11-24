package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.example.carrotmarket.databinding.FragmentHomeBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // 바인딩 클래스 가져오기


        binding.navigation.setOnItemSelectedListener {
            // onClickListener가 아닌 onItemSelectedListener 함수를 사용함
            when(it.itemId){ // 선택된 아이템의 id가 인자로 들어옴에 따라
                R.id.menu_home -> { // fragment를 전환함
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commit()
                    return@setOnItemSelectedListener true // Listener 함수의 타입 때문에 리턴 값 필요
                }
                R.id.menu_townlife -> { // 이전 Fragment의 상태를 저장하지 않음(백스택을 쓰지 않는 상태)
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, TownLifeFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_nearby -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, NearbyFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_chatting -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, ChattingFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_my -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, MyCarrotFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener true
                }
            }
        }
        binding.navigation.selectedItemId = R.id.menu_home
    }
}