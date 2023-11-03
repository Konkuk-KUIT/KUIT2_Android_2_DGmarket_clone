package com.example.carrotmarket

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityStuffInfoBinding
    var imgList = mutableListOf<String>()

    private val pagerHandler = Handler(Looper.getMainLooper())
    private val imageSwiper = ImageSwiper()
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

        initDummyData()
        initViewPager()

        imageSwiper.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        imageSwiper.interrupt()
    }

    inner class ImageSwiper: Thread(){
        override fun run() {
            try{
                while(true){
                    sleep(1000)
                    pagerHandler.post{
                        var position = binding.imageAreaVp.currentItem
                        if(position==2){
                            position=0
                        }else{
                            position++
                        }

                        binding.imageAreaVp.currentItem=position
                    }
                }
            }catch (e: InterruptedException){
                Log.d("INTERRUPT","쓰레드 종료")
                interrupt()
            }
        }
    }

    private fun initViewPager() {
        binding.imageAreaVp.adapter=ImageSlideVPAdapter(applicationContext,imgList)
        binding.imageAreaVp.orientation=ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun initDummyData() {
        imgList.add("https://cdn.pixabay.com/photo/2018/05/01/18/21/eclair-3366430_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2017/05/04/21/23/cupcakes-2285209_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2018/07/01/19/50/muffin-3510308_1280.jpg")
    }

//    private fun initView(data: String?) {
//        if (data == null) {
//            finish()
//            return
//        }
//
//        // TODO: 받은 데이터를 StuffInfoActivity의 해당하는 View에 적용해보기
//}
}