package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentMyBinding

class MyCarrotFragment : Fragment() {
    lateinit var binding : FragmentMyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyBinding.inflate(layoutInflater)

        binding.btnLoginMy.setOnClickListener {
            val loginIntent = Intent(requireContext(),LoginActivity::class.java)
            startActivity(loginIntent)
        }

        return binding.root
    }
}