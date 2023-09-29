package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.util.Log
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

        binding.clItem1.setOnClickListener {
            val intent = Intent(requireContext(),StuffInfoActivity::class.java) //fragment에서는 this 대신 requiereContext(main Activity로 만들어줌)를 쓴다.
            startActivity(intent)
        }

        binding.ivAlarm.setOnClickListener {
            val intent = Intent(requireContext(),AlarmActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}