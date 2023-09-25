package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityStuffinfoBinding

class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding : ActivityStuffinfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val key = intent.getIntExtra("key", 0)
        val picture = intent.getIntExtra("picture", R.drawable.product)
        var price = intent.getStringExtra("price")

        if(key == 0){
            price = "500,000원"
        }

        binding.ivProduct.setImageResource(picture)
        binding.tvPrice.setText(price)

        binding.btnPrevious.setOnClickListener {
            finish()
        }



    }
}