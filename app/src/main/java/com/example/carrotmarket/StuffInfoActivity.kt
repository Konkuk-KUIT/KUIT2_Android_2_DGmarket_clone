package com.example.carrotmarket

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding : ActivityStuffInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("Key",Transaction::class.java)
        } else {
            intent.getSerializableExtra("Key") as Transaction
        } ?: Transaction(R.drawable.icon_warning_gray,"제목 없음","-1초전","버뮤다","-10,000원",0,0)

        binding.ivDetailView.setImageResource(data.trans_img)
        binding.tvItemInfoTitle.text=data.trans_title
        binding.tvItemInfoPos.text=data.trans_pos
        binding.tvItemInfoTimeline.text=data.trans_timeline
        binding.tvItemInfoPrice.text=data.trans_price

        binding.ivStuffBack.setOnClickListener {
            finish()
        }
    }
}