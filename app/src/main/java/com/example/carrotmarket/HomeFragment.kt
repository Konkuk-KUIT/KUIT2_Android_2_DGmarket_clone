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
        initStuffInfo()
        initAlarm()

        return binding.root
    }

    private fun initStuffInfo(){
        binding.clItem1.setOnClickListener{
            val intent = Intent(requireActivity(), StuffInfoActivity::class.java)
            startActivity(intent)
        }

    }

    private fun initAlarm(){
        binding.ivHomeAlarm.setOnClickListener {
            val intent = Intent(requireActivity(),AlarmActivity::class.java)
            startActivity(intent)
        }
    }

}