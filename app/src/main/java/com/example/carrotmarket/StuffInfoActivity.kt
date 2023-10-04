package com.example.carrotmarket

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.carrotmarket.DataClass.Product
import com.example.carrotmarket.databinding.ActivityStuffinfoBinding

class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding : ActivityStuffinfoBinding
    lateinit var product_info : Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            product_info = intent.getSerializableExtra("product_data", Product::class.java)!!
        } else {
            product_info = intent.getSerializableExtra("product_data") as Product
        }

        val product_img = product_info.product_img
        val product_title = product_info.product_title
        val product_id = product_info.product_id
        val product_price = product_info.product_price


        binding.ivProduct.setImageResource(product_img)
        binding.tvUserCity.text = product_id
        binding.announceTitle.text = product_title
        binding.tvPrice.text = product_price

//        val key = intent.getIntExtra("key", 0)
//        val picture = intent.getIntExtra("picture", R.drawable.product)
//        var price = intent.getStringExtra("price")
//
//        if(key == 0){
//            price = "500,000원"
//        }
//
//        binding.ivProduct.setImageResource(picture)
//        binding.tvPrice.setText(price)

        binding.btnPrevious.setOnClickListener {
            finish()
        }



    }
}