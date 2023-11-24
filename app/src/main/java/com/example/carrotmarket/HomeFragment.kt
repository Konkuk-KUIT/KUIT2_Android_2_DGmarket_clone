package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var productAdapter:ProductAdapter?=null
    val product_list = ArrayList<Product>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.ivHomeAlarm.setOnClickListener {
            val intent = Intent(requireContext(), AlarmActivity::class.java)
            startActivity(intent)
        }

        binding.recyclerView.setOnClickListener {
            val intent = Intent(requireContext(), ProductActivity::class.java)
            startActivity(intent)
        }

        initProductList()
        initRecyclerView()
        return binding.root
    }

    private fun initRecyclerView() {
        productAdapter = ProductAdapter(product_list)
        binding.recyclerView.adapter = productAdapter
        binding.recyclerView.layoutManager=LinearLayoutManager(context)
        // context도 되고 requireContext()도 가능

        productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener{
            override fun onItemClick(product: Product) {
                val intent = Intent(context, ProductActivity::class.java)
                intent.putExtra("product_data", product)
                startActivity(intent)
                Log.d("clickEvent", "클릭됐음")
            }
        })
    }

    private fun initProductList() {
        product_list.add(
            Product(
                R.drawable.bear,
                "곰인형1 팔아요",
                "의정부1동",
                "200만원",
                99,
                88
            )
        )
        product_list.add(
            Product(
                R.drawable.teddybear,
                "곰인형2 팔아요",
                "의정부2동",
                "300만원",
                99,
                88
            )
        )
        product_list.add(
            Product(
                R.drawable.carrotimg,
                "당근 팔아요",
                "의정부3동",
                "400만원",
                99,
                88
            )
        )
        product_list.add(
            Product(
                R.drawable.bear,
                "곰인형1 팔아요",
                "의정부4동",
                "500만원",
                99,
                88
            )
        )
        product_list.add(
            Product(
                R.drawable.teddybear,
                "곰인형2 팔아요",
                "의정부5동",
                "600만원",
                99,
                88
            )
        )
        product_list.add(
            Product(
                R.drawable.carrotimg,
                "당근 팔아요",
                "의정부6동",
                "700만원",
                99,
                88
            )
        )
        product_list.add(
            Product(
                R.drawable.bear,
                "곰인형1 팔아요",
                "의정부동",
                "800만원",
                99,
                88
            )
        )
        product_list.add(
            Product(
                R.drawable.teddybear,
                "곰인형2 팔아요",
                "의정부동",
                "1000만원",
                99,
                88
            )
        )
        product_list.add(
            Product(
                R.drawable.carrotimg,
                "당근 팔아요",
                "의정부동",
                "1100만원",
                99,
                88
            )
        )

    }

    // Fragment 생명 주기
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val productAdapter = ProductAdapter(product_list)
//        binding.recyclerView.adapter = productAdapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        productAdapter.setOnItemClickListener(object : ProductAdapter.OnItemClickListener {
//            override fun onItemClick(product: Product) {
//                // 항목 클릭 처리
//                val intent = Intent(requireContext(), ProductActivity::class.java)
//                intent.putExtra("product_data", product)
//                startActivity(intent)
//                Log.d("clickEvent", "클릭됐음")
//            }
//        })
//    }

//    private fun attachProductAdapter() {
//        productAdapter = ProductAdapter(product_list)
//        // TODO: 작성한 어댑터를 binding과 연결하고 layoutManager 등록하기
//
//
//        // TODO : setOnItemClickListener에 제공할 인터페이스를 익명 클래스로 작성하고,  화면 클릭 이벤트 구현하기
////        productAdapter!!.setOnItemClickListener(
////
////        )
//    }







}