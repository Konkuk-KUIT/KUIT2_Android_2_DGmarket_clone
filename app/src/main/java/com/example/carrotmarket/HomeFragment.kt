package com.example.carrotmarket

import android.content.Intent
import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var productAdapter: ProductAdapter?= null
    private var productList: ArrayList<ProductInfo> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        initAlarm()
        initProduct()
        initRecyclerView()

        return binding.root
    }

    private fun initProduct() {
        productList.addAll(
            arrayListOf(
                ProductInfo(R.drawable.ic_item_thumbnail_1,"서울특별시 강서구","상품1 슬리퍼 팝니다","1,000원"),
                ProductInfo(R.drawable.ic_item_thumbnail_2,"서울특별시 광진구","상품2 공학관 팝니다","2,000원"),
                ProductInfo(R.drawable.ic_item_thumbnail_3,"서울특별시 금천구","상품3 새천년관 팝니다","3,000원"),
                ProductInfo(R.drawable.ic_item_thumbnail_4,"서울특별시 용산구","상품4 신공학관 팝니다","4,000원"),
                ProductInfo(R.drawable.ic_item_thumbnail_5,"서울특별시 서초구","상품5 경영관 팝니다","5,000원"),
                ProductInfo(R.drawable.ic_item_thumbnail_6,"서울특별시 관악구","상품6 동생대 팝니다","6,000원"),
                ProductInfo(R.drawable.ic_item_thumbnail_7,"서울특별시 구로구","상품7 예디대 팝니다","7,000원"),
                ProductInfo(R.drawable.ic_item_thumbnail_1,"서울특별시 양천구","상품8 제목","8,000원"),
                ProductInfo(R.drawable.ic_item_thumbnail_2,"서울특별시 강남구","상품9 제목","9,000원"),
                ProductInfo(R.drawable.ic_item_thumbnail_3,"서울특별시 송파구","상품10 제목","10,000원"),
                )
        )
    }

    private fun initRecyclerView() {
        productAdapter = ProductAdapter(productList)
        binding.rvHomeProduct.adapter = productAdapter
        binding.rvHomeProduct.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
        //requirecontext -> context : getContext()로 받아짐

        productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener{
            override fun onItemClick(productInfo: ProductInfo) {
                val intent = Intent(requireActivity(), StuffInfoActivity::class.java)
                intent.putExtra("Key",productInfo)
                startActivity(intent)
            }

        })
    }


    private fun initAlarm(){
        binding.ivHomeAlarm.setOnClickListener {
            val intent = Intent(requireActivity(),AlarmActivity::class.java)
            startActivity(intent)
        }
    }

}