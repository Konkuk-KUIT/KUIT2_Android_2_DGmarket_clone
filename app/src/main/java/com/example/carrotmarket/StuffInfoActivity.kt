package com.example.carrotmarket

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.os.Handler
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    //View binding 적용
    lateinit var binding : ActivityStuffInfoBinding
    //suff_product_image에 들어갈 데이터 선언
    private val suff_product_imgList = mutableListOf<String>()

    //핸들러
    private val pagerHandler = Handler(Looper.getMainLooper())

    //이미지를 자동으로 넘겨주는 Swiper
    private val imageSwiper = ImageSwiper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSuffProductImageDummyData()

        //뷰페이저 설정
        initSuffProductViewPager()

        //이미지 스와이퍼
        imageSwiper.start()

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
        } ?: MyProduct("temp","temp", "temp","temp","temp","temp", R.drawable.app_icon_splash_logo) //null값이 들어올 경우 임시값으로 temp값들 넣어줌.

        //받은 데이터를 받은 클래스의 xml에 적용
        binding.tvSuffProductTitle.text = data.producttitle
        binding.tvSuffProductRegion.text = data.productregion
        binding.tvSuffProductTime.text = data.producttime
        binding.tvSuffProductPrice.text = data.productprice

        //suff_product_imgList[0] = data.productimage.toString()
    }

    override fun onDestroy() {
        super.onDestroy()
        imageSwiper.interrupt()
    }

    inner class ImageSwiper : Thread(){
        override fun run() {
            try {
                while(true){
                    sleep(1000)
                    pagerHandler.post{  //new runnable
                        var position = binding.suffProductImageVp.currentItem
                        if(position == 4){
                            position = 0
                        }else{
                            position++
                        }
                        binding.suffProductImageVp.currentItem = position
                    }
                }
            }catch (e:InterruptedException){
                Log.d("INTERRUPT", "스레드 종료")
                interrupt()
            }
        }


    }

    private fun initSuffProductViewPager() {
        binding.suffProductImageVp.adapter = SuffProductImgSliderVPAdapter(applicationContext, suff_product_imgList)

        //가로로 스와이프(기본값은 세로)
        binding.suffProductImageVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun initSuffProductImageDummyData() {
        suff_product_imgList.add("https://m.jejuttam.com/web/product/big/202112/0d265ea52adea6eca3da9aa034c4f5ae.jpg")
        suff_product_imgList.add("https://m.haepoom.com/web/product/big/202211/421855678ac23ada9fb888c7fd311fbf.png")
        suff_product_imgList.add("https://www.jicexpo.com/images/client/jicexpo/mainAllExpo.png")
        suff_product_imgList.add("https://www.jejuilbo.net/news/photo/202001/137397_86036_4628.jpg")
        suff_product_imgList.add("https://m.ddingdongjeju.com/web/product/medium/202012/304087aafb2a1f89fe401cb71883c741.jpg")
    }
}