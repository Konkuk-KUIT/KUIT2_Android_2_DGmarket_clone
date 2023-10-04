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

        parentFragmentManager.beginTransaction().replace(R.id.fl_stuff_info, HomeScrollFragment()).commit()

        // 기능 추가
//        binding.clItem1.setOnClickListener {
//            val intent = Intent(requireContext(), StuffInfoActivity::class.java) // ::은 리플렉션이라고 함 왜 .java붙음?
//            startActivity(intent)
//        }
//        binding.clItem2.setOnClickListener {
//            val intent = Intent(requireContext(), StuffInfoActivity::class.java) // ::은 리플렉션이라고 함 왜 .java붙음?
//            startActivity(intent)
//        }

        binding.ivHomeAlarm.setOnClickListener {
            val intent = Intent(requireContext(), AlarmActivity::class.java) // ::은 리플렉션이라고 함 왜 .java붙음?
            startActivity(intent)
        }
        return binding.root
    }

}