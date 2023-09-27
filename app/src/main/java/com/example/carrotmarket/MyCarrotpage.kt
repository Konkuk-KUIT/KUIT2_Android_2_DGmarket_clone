package com.example.carrotmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentMyCarrotpageBinding

class MyCarrotFragment : Fragment() {
    lateinit var binding : FragmentMyCarrotpageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCarrotpageBinding.inflate(layoutInflater)
        return binding.root
    }
}