package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    var productAdapter: ProductAdapter? = null
    var productList: ArrayList<Product> = arrayListOf()
    var productDB : ProductDB?=null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //기능추가, 알람

        binding.ivHomeAlarm.setOnClickListener {
            val intent=Intent(requireContext(),AlarmActivity::class.java)
            startActivity(intent)
        }

        //item1Layout이 뭐야?

        productDB=ProductDB.getInstance(requireContext())
        return binding.root
    }
    // Fragment 생명 주기
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            initDummyData()
            val products = productDB!!.getProductDAO().getProducts()

            val arrList = arrayListOf<Product>()
            arrList.addAll(productDB!!.getProductDAO().getProducts())
            productList=arrList

            withContext(Dispatchers.Main) {
                (binding.rvProductList.adapter as ProductAdapter).setData(products)
            }
        }
        attachProductAdapter()
    }

    private fun attachProductAdapter() {
        productAdapter = ProductAdapter(productList)
        // TODO: 작성한 어댑터를 binding과 연결하고 layoutManager 등록하기
        binding.rvProductList.adapter=productAdapter
        binding.rvProductList.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)


        productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener{
            override fun onItemClick(product : Product){
                val intent = Intent(requireContext(),StuffInfoActivity::class.java)
                intent.putExtra("key",product)
                startActivity(intent)
            }

        })
    }

    //리사이클러뷰에 데이터(리스트) 추가하기
    private fun initDummyData() {
        productDB!!.getProductDAO().addProduct(
            Product(1,"컴퓨터","송민서","20만원",13)
        )
    }
}