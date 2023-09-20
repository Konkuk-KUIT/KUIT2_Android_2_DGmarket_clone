package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentNotifyBinding

class NotifyFragment : Fragment() {
    lateinit var binding : FragmentNotifyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentNotifyBinding.inflate(layoutInflater)
        return binding.root
    }


}