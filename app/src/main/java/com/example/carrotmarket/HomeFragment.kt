package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    //프로퍼티로 productlist 만듦
    private var productList:ArrayList<MyProduct> = arrayListOf()

    //만든 ProductAdapter 활용
    private var productAdapter:ProductAdapter?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

//        //기능 추가
//        //상품 아이템 박스 선택하면 상세 상품 페이지로 넘어가도록 설정
//        binding.rvProduct.setOnClickListener {
//            val intent = Intent(requireContext(), StuffInfoActivity::class.java)
//            startActivity(intent)
//        }

        //알람 아이콘 선택하면 알람 페이지로 넘어가도록 설정
        binding.ivHomeAlarm.setOnClickListener {
            val intent = Intent(requireContext(), AlarmActivity::class.java)
            startActivity(intent)
        }

        //Homefragment의 Product(데이터)를 구성하는 함수
        initProduct()

        //ProductAdapter에 대한 작업
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        productAdapter = ProductAdapter(productList)

        //binding의 rv_Product의 adapter를 만들어 놓은 productAdapter로 설정
        binding.rvProduct.adapter = productAdapter

        //layoutmanager을 사용해서 Vertical = 세로 형태로 레이아웃을 출력하기 위해 orientation 설정
        binding.rvProduct.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)

        //productAdapter에 setOnItemClickListener 호출
        productAdapter!!.setOnItemClickListener(object :ProductAdapter.OnItemClickListener{
            override fun onItemClick(myProduct: MyProduct) {
                //item 클릭했을 때 상세화면으로 전환
                val intent = Intent(requireContext(), StuffInfoActivity::class.java)
                //상세 product에 대한 데이터 전송
                intent.putExtra("key",myProduct)
                startActivity(intent)
            }
        })

    }

    private fun initProduct() {
        productList.addAll(
            arrayListOf(
                MyProduct("생귤탱귤 제주 감귤 판매🍊","서귀포시 • 끌올 1분 전","20,000원","6","5" , R.drawable.image),
                MyProduct("급처) 러쉬 스프레이","계양구 계산동 • 끌올 1분 전","10,000원","8","11" , R.drawable.img_1),
                MyProduct("미니 고데기(거의 새거)✨","계양구 작전동 • 8초 전","10,000원","0","4" , R.drawable.img_3),
                MyProduct("🧡9월 이달의 아트🧡","원종동 • 5분 전","40,000원","6","5" , R.drawable.img_4),
                MyProduct("코닥 필름카메라","작동 • 41분 전","10,000원","1","1" , R.drawable.img_5),
                MyProduct("조말론 블랙베리 향수 100ml","서울특별시 양천구 • 2시간 전","130,000원","2","1" , R.drawable.img_11),
                MyProduct("한성 키보드","서울특별시 강서구 • 8시간 전","90,000원","4","5" , R.drawable.img_7),
                MyProduct("하늘색 플레어 스커트","부평구 삼산동 • 4시간 전","20,000원","3","7" , R.drawable.img_9)
            )
        )
    }

}