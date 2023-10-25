package com.example.carrotmarket

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding : ActivityStuffInfoBinding
    private val imgList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDummyData()
        initViewPager()

        val data= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("Key",Transaction::class.java)
        } else {
            intent.getSerializableExtra("Key") as Transaction
        } ?: Transaction(R.drawable.icon_warning_gray,"제목 없음","-1초전","버뮤다","-10,000원",0,0)

        //binding.itemDetailIv.setImageResource(data.trans_img)
        binding.tvItemInfoTitle.text=data.trans_title
        binding.tvItemInfoPos.text=data.trans_pos
        binding.tvItemInfoTimeline.text=data.trans_timeline
        binding.tvItemInfoPrice.text=data.trans_price

        binding.ivStuffBack.setOnClickListener {
            finish()
        }
    }

    private fun initViewPager() {
        binding.detailViewVp.adapter = ImageSliderVPAdapter(applicationContext,imgList)
        binding.detailViewVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun initDummyData() {
        imgList.add("https://cdn.pixabay.com/photo/2016/08/11/17/53/roe-deer-1586373_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2017/04/27/03/52/deer-2264354_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2015/01/17/13/54/fallow-deer-602253_1280.jpg")
    }
}