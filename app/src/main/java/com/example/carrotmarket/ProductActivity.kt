package com.example.carrotmarket

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.databinding.ProductDetailBinding
import java.io.Serializable

class ProductActivity : AppCompatActivity() {
    lateinit var binding:ProductDetailBinding
    private val imgList = mutableListOf<String>()
//    private val textList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val product_info = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            product_info = intent.getSerializableExtra("product_info", Product::class.java) ?: "asdf"
//            val product_info =
                intent.getSerializableExtra("product_data", Product::class.java) ?: "asdf" as Product
//                    ?: (R.drawable.carrotimg, "제목", "주소", "가격", 0, 0 ) as Product
//            val product_img = product_info.product_img
//            val product_title = product_info.product_title
//            val product_address = product_info.product_address
//            val product_price = product_info.product_price
//
////            binding.vpImage.setImageResource(product_img)
//            binding.tvAddress.text = product_address
//            binding.tvTitle.text = product_title
//            binding.tvPrice.text = product_price

        } else { // 버전이 tiramisu보다 낮을 때
            intent.getSerializableExtra("product_data") as Product?
        } ?: Product(1, "temp", "temp","temp", 1, 2)

        val product_img = product_info.product_img
        val product_title = product_info.product_title
        val product_address = product_info.product_address
        val product_price = product_info.product_price

            binding.ivProduct.setImageResource(product_img)
        binding.tvAddress.text = product_address
        binding.tvTitle.text = product_title
        binding.tvPrice.text = product_price


        initDummyData()
//        initViewPager()



        binding.backBtn.setOnClickListener{
            finish()
            Log.d("ProductActivity", "backBtn 클릭")
        }

    }

//    private fun initViewPager() {
//        binding.vpImage.adapter = ImageSliderVPAdapter(applicationContext, imgList)
//        binding.vpImage.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//
//    }

    private fun initDummyData() {
        imgList.add("https://cdn.pixabay.com/photo/2017/02/20/18/03/cat-2083492_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2017/07/25/01/22/cat-2536662_1280.jpg")
    }
}