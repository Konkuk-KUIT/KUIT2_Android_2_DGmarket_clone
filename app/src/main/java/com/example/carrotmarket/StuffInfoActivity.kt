package com.example.carrotmarket

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityStuffInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //back 버튼에 activity 종료 => finish()
        binding.arrow.setOnClickListener {
            finish()
        }
        // TODO: intent으로 전달 받은 데이터를 getStringExtra() 으로 받아오기
        //  챌린지 미션: Serializable로 받아온 Data class를 이용해보기
        // val data = ???
        val data=if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("key",ProductInfo::class.java)
        }else{
            intent.getSerializableExtra("key")as ProductInfo
        }?:ProductInfo(1,"와우","밍","잘못구현?",2,3)

    }
    private fun initView(data: String?) {
        if (data == null) {
            finish()
            return
        }

        // TODO: 받은 데이터를 StuffInfoActivity의 해당하는 View에 적용해보기
}
}