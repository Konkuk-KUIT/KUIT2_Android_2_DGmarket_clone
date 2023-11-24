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
    private var productAdapter: ProductAdapter?= null
    var productList: ArrayList<ProductEntity> = arrayListOf()
    var productDB : ProductDB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        initAlarm()
        //initProduct()
        //initRecyclerView()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productDB = ProductDB.getInstance(requireContext())

        CoroutineScope(Dispatchers.IO).launch {
            initDummyData()

            val arrList = arrayListOf<ProductEntity>()
            arrList.addAll(productDB!!.getProductDAO().getProducts())
            productList = arrList

            withContext(Dispatchers.Main){
                (binding.rvHomeProduct.adapter as ProductAdapter).setData(productList)
            }
        }

        productAdapter = ProductAdapter(productList)
        binding.rvHomeProduct.adapter = productAdapter
        binding.rvHomeProduct.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)

        productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener{
            override fun onItemClick(productInfo: ProductEntity) {
                val intent = Intent(requireActivity(), StuffInfoActivity::class.java)
                intent.putExtra("Key", productInfo)
                startActivity(intent)
            }
        })
    }

    private fun initDummyData(){
        //DAO가 database를 바로 접근할 수 없으니 도와주는 매개역할
        productDB!!.getProductDAO().addProduct(
            ProductEntity(
                productImage = R.drawable.ic_item_thumbnail_1,
                productLocation = "서울특별시 강서구",
                productTitle = "상품1 슬리퍼 팝니다",
                productPrice = "1,000원"
            )
        )
        productDB!!.getProductDAO().addProduct(
            ProductEntity(
                productImage = R.drawable.ic_item_thumbnail_2,
                productLocation = "서울특별시 광진구",
                productTitle = "상품2 공학관 팝니다",
                productPrice = "2,000원"
            )
        )
        productDB!!.getProductDAO().addProduct(
            ProductEntity(
                productImage = R.drawable.ic_item_thumbnail_3,
                productLocation = "서울특별시 금천구",
                productTitle = "상품3 새천년관 팝니다",
                productPrice = "3,000원"
            )
        )
        productDB!!.getProductDAO().addProduct(
            ProductEntity(
                productImage = R.drawable.ic_item_thumbnail_4,
                productLocation = "서울특별시 용산구",
                productTitle = "상품4 신공학관 팝니다",
                productPrice = "4,000원"
            )
        )
        productDB!!.getProductDAO().addProduct(
            ProductEntity(
                productImage = R.drawable.ic_item_thumbnail_5,
                productLocation = "서울특별시 서초구",
                productTitle = "상품5 경영관 팝니다",
                productPrice = "5,000원"
            )
        )
        productDB!!.getProductDAO().addProduct(
            ProductEntity(
                productImage = R.drawable.ic_item_thumbnail_6,
                productLocation = "서울특별시 관악구",
                productTitle = "상품6 동생대 팝니다",
                productPrice = "6,000원"
            )
        )
        productDB!!.getProductDAO().addProduct(
            ProductEntity(
                productImage = R.drawable.ic_item_thumbnail_7,
                productLocation = "서울특별시 구로구",
                productTitle = "상품7 예디대 팝니다",
                productPrice = "7,000원"
            )
        )
        productDB!!.getProductDAO().addProduct(
            ProductEntity(
                productImage = R.drawable.ic_item_thumbnail_1,
                productLocation = "서울특별시 송파구",
                productTitle = "상품8 제목 팝니다",
                productPrice = "8,000원"
            )
        )
        productDB!!.getProductDAO().addProduct(
            ProductEntity(
                productImage = R.drawable.ic_item_thumbnail_2,
                productLocation = "서울특별시 양천구",
                productTitle = "상품9 제목 팝니다",
                productPrice = "9,000원"
            )
        )
        productDB!!.getProductDAO().addProduct(
            ProductEntity(
                productImage = R.drawable.ic_item_thumbnail_3,
                productLocation = "서울특별시 강남구",
                productTitle = "상품10 제목 팝니다",
                productPrice = "10,000원"
            )
        )
    }

    /*private fun initProduct() {
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
    }*/

    private fun initRecyclerView() {
        productAdapter = ProductAdapter(productList)
        binding.rvHomeProduct.adapter = productAdapter
        binding.rvHomeProduct.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, false)
        //requirecontext -> context : getContext()로 받아짐

        /*productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener{
            override fun onItemClick(productInfo: ProductEntity) {
                val intent = Intent(requireActivity(), StuffInfoActivity::class.java)
                intent.putExtra("Key",productInfo)
                startActivity(intent)
            }

        })*/
    }

    private fun initAlarm(){
        binding.ivHomeAlarm.setOnClickListener {
            val intent = Intent(requireActivity(),AlarmActivity::class.java)
            startActivity(intent)
        }
    }
    
}