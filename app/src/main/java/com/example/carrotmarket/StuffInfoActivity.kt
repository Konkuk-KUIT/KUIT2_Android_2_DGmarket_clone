package com.example.carrotmarket

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    //View binding 적용
    lateinit var binding : ActivityStuffInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //기능 추가
        //뒤로 가기 아이콘 선택하면 HomeFragment 페이지로 넘어가도록 설정
        binding.tvInfoPreviousArrow.setOnClickListener {
            finish()
        }
        //intent를 통해 이전 화면에서 데이터를 받을 때
        //key값을 가지지 않는다면, 데이터에 null이 들어올 수 있음.
        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("key",MyProduct::class.java)
        } else {
            intent.getSerializableExtra("key")as MyProduct
        } ?: MyProduct("temp","temp","temp","temp","temp", R.drawable.app_icon_splash_logo) //null값이 들어올 경우 임시값으로 temp값들 넣어줌.

        //받은 데이터를 받은 클래스의 xml에 적용
        binding.tvSuffProductTitle.text = data.producttitle
        binding.tvSuffProductRegion.text = data.productregion
        binding.tvSuffProductPrice.text = data.productprice
        binding.ivSuffProductImage.setImageResource(data.productimage)

    }
}