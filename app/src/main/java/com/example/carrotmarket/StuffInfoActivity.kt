package com.example.carrotmarket

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide.init
import com.example.carrotmarket.databinding.ActivityStuffinfoBinding


class StuffInfoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityStuffinfoBinding
    private val imgList = mutableListOf<String>()

    private val pagerHandler = Handler(Looper.getMainLooper())
    private val imageSwiper = ImageSwiper()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityStuffinfoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initDummyData()
        initViewPager()
        init()
        initStatusBar()
        initScrollView()

        binding.ivBackHome.setOnClickListener{
            finish()
        }

        imageSwiper.start()
        //start는 thread 생성(멀티 쓰레드), run은 thread 실행(싱글 쓰레드)
    }

    override fun onDestroy() {
        super.onDestroy()
        imageSwiper.interrupt()
    }

    inner class ImageSwiper(): Thread() {
        override fun run() {
            try{
                while(true){
                    sleep(3000)
                    pagerHandler.post{
                        var position = binding.vpThumbnailIn.currentItem
                        if(position == 7){
                            position = 0
                        }else{
                            position++
                        }
                        binding.vpThumbnailIn.currentItem = position
                    }
                }

            }catch (e : InterruptedException){
                Log.e("INTERRUPT", "쓰레드 종료")
            }
        }

    }


    private fun initViewPager() {
        binding.vpThumbnailIn.adapter = StuffInfoVPAdapter(applicationContext,imgList)
        binding.vpThumbnailIn.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun initDummyData() {
        imgList.add("https://media.istockphoto.com/id/1482199015/ko/%EC%82%AC%EC%A7%84/%ED%96%89%EB%B3%B5%ED%95%9C-%EA%B0%95%EC%95%84%EC%A7%80-%EC%9B%A8%EC%9D%BC%EC%8A%A4-%EC%96%B4-%EC%BD%94%EA%B8%B0-14-%EC%A3%BC%EB%A0%B9-%EA%B0%9C%EA%B0%80-%EC%9C%99%ED%81%AC%ED%95%98%EA%B3%A0-%ED%97%90%EB%96%A1%EC%9D%B4%EA%B3%A0-%ED%9D%B0%EC%83%89%EC%97%90-%EA%B3%A0%EB%A6%BD%EB%90%98%EC%96%B4-%EC%95%89%EC%95%84-%EC%9E%88%EC%8A%B5%EB%8B%88%EB%8B%A4.jpg?s=612x612&w=is&k=20&c=CkTkWxs_QitkIcwMhbE155bnuLBoRBQ_AQaDNRh0Bh8=")
        imgList.add("https://cdn.pixabay.com/photo/2019/08/07/14/11/dog-4390885_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2019/07/23/13/51/shepherd-dog-4357790_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2017/09/25/13/12/puppy-2785074_1280.jpg")
        imgList.add("https://media.istockphoto.com/id/1480747819/ko/%EC%82%AC%EC%A7%84/%EB%8B%A5%EC%8A%A4-%EC%88%9C%EB%93%9C%EC%99%80-%EA%B3%A0%EC%96%91%EC%9D%B4-%EA%B0%80%EC%9E%A5-%EC%B9%9C%ED%95%9C-%EC%B9%9C%EA%B5%AC.jpg?s=2048x2048&w=is&k=20&c=lyjV_IffYM2g2xAey6T6uon4gYkbu_KRlKnZsWPg_ZU=")
        imgList.add("https://cdn.pixabay.com/photo/2018/05/11/08/11/dog-3389729_1280.jpg")
        imgList.add("https://media.istockphoto.com/id/1267541412/ko/%EC%82%AC%EC%A7%84/%EB%B9%A8%EA%B0%84-%EC%82%B0%ED%83%80-%ED%81%B4%EB%A1%9C%EC%8A%A4-%EB%AA%A8%EC%9E%90%EC%99%80-%EC%9B%83%EB%8A%94-%ED%91%9C%EC%A0%95%EC%9C%BC%EB%A1%9C-%ED%81%AC%EB%A6%AC%EC%8A%A4%EB%A7%88%EC%8A%A4%EB%A5%BC-%EC%B6%95%ED%95%98%ED%95%98%EB%8A%94-%ED%96%89%EB%B3%B5%ED%95%9C-%EA%B0%95%EC%95%84%EC%A7%80-%EA%B0%9C.jpg?s=2048x2048&w=is&k=20&c=iDp7DehrScAiZTNH-MnP05eOOaTpN3SVv-8DIH5dfXY=")
    }


    private fun init(){

        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("Key",ProductEntity::class.java)
        } else {
            intent.getSerializableExtra("Key") as ProductEntity
        } ?: ProductEntity(0,"null","null","null")

        binding.tvBottomBarPrice.text = data.productPrice
        binding.tvProductTitleIn.text = data.productTitle
        binding.tvProductLocationIn.text = data.productLocation

        val text = "여기에 물건을 팔 때 텍스트가 입력됩니다.\n"
        val text2 = "여기는 두 번째 문단이 입력됩니다\n"
        var result = ""

        for(i in 0..10){
            result+=text
        }

        result+="\n"

        for(i in 0..10){
            result+=text2
        }

        binding.ttExample.text = result
    }

    private fun initStatusBar(){
        val window = window
        //window.statusBarColor = Color.BLUE
        window.statusBarColor = Color.TRANSPARENT

    }

    private fun initScrollView(){
        binding.svStuffInfo.setOnScrollChangeListener { _: NestedScrollView?, _:Int, scrollY: Int, _: Int, _: Int ->
            if(scrollY > 0){
                window.statusBarColor = ContextCompat.getColor(this,R.color.gray_700)
            }else{
                window.statusBarColor = Color.TRANSPARENT
            }
        }
    }
}