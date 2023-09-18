package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //기능 추가
        //상품 아이템 박스 선택하면 상세 상품 페이지로 넘어가도록 설정
        binding.clItem1.setOnClickListener {
            val intent = Intent(requireContext(), StuffInfoActivity::class.java)
            startActivity(intent)
        }

        //알람 아이콘 선택하면 알람 페이지로 넘어가도록 설정
        binding.ivHomeAlarm.setOnClickListener {
            val intent = Intent(requireContext(), AlarmActivity::class.java)
            startActivity(intent)
        }



        return binding.root

    }

}