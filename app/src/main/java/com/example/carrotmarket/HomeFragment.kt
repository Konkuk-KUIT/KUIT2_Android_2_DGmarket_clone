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

    var productAdapter: ProductAdapter? = null
    val productList: ArrayList<ProductInfo> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //기능추가, 알람

        binding.ivHomeAlarm.setOnClickListener {
            var intent=Intent(requireContext(),AlarmActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
    // Fragment 생명 주기
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummyData()
        attachProductAdapter()
    }

    private fun attachProductAdapter() {
        productAdapter = ProductAdapter(productList)
        // TODO: 작성한 어댑터를 binding과 연결하고 layoutManager 등록하기
        binding.rvProductList.adapter=productAdapter
        binding.rvProductList.layoutManager=LinearLayoutManager(requireContext())


        // TODO : setOnItemClickListener에 제공할 인터페이스를 익명 클래스로 작성하고,  화면 클릭 이벤트 구현하기
        productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener{
            override fun onItemClick(productInfo: ProductInfo) {
                val intent=Intent(requireContext(),StuffInfoActivity::class.java)
                intent.putExtra("product_data",productInfo)
                startActivity(intent)
            }

        })
    }

    // TODO: 각자 구성한 데이터 클래스에 맞게 더미 데이터를 구성해보기
    private fun initDummyData() {
        productList.addAll(
            arrayListOf(
                ProductInfo(1,"컴퓨터","송민서","20만원",13,20),
                ProductInfo(1,"컴퓨터","송민서","20만원",13,20),
                ProductInfo(1,"컴퓨터","송민서","20만원",13,20),
                ProductInfo(1,"컴퓨터","송민서","20만원",13,20),
                ProductInfo(1,"컴퓨터","송민서","20만원",13,20),
                ProductInfo(1,"컴퓨터","송민서","20만원",13,20)
            )
        )
    }

}