package com.example.carrotmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carrotmarket.databinding.FragmentKeywordNotiftyBinding

class KeywordNotify : Fragment() {
    lateinit var binding : FragmentKeywordNotiftyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKeywordNotiftyBinding.inflate(layoutInflater)
        return binding.root
    }
}