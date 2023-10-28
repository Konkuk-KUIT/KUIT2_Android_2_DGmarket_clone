package com.example.carrotmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carrotmarket.databinding.FragmentExerciseAlarmBinding
import com.example.carrotmarket.databinding.FragmentKeywordAlarmBinding

class KeywordAlarmFragment : Fragment() {
    private lateinit var binding : FragmentKeywordAlarmBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKeywordAlarmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTemporaryExerciseImageView()
    }

    private fun initTemporaryExerciseImageView() {
        binding.temporaryKeywordIv.setImageResource(R.drawable.img_5)
    }

}