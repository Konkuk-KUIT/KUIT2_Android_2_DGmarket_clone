package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val transList: ArrayList<Transaction> = arrayListOf()
    private var productAdapter: ProductAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        /*
        binding.clItem1.setOnClickListener {
            val intent = Intent(requireContext(),StuffInfoActivity::class.java) //fragment에서는 this 대신 requiereContext(main Activity로 만들어줌)를 쓴다.
            startActivity(intent)
        }*/

        binding.ivAlarm.setOnClickListener {
            val intent = Intent(requireContext(),AlarmActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initData()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        productAdapter = ProductAdapter(transList)
        binding.clRecyclerView.adapter = productAdapter
        binding.clRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener{
            override fun onItemClick(myTrans: Transaction) {
                //Toast.makeText(context,myTrans.trans_title,Toast.LENGTH_SHORT).show()
                val intent = Intent(context,StuffInfoActivity::class.java)
                intent.putExtra("Key",myTrans)
                startActivity(intent)
            }
        })
    }

    private fun initData() {
        transList.addAll(
            arrayListOf(
                Transaction(R.drawable.img_1709,"기르던 사슴 분양합니다","58초 전","서울특별시 동대문구","19,000원",1,1),
                Transaction(R.drawable.img_1341,"고급 스시 상하기 전에 가져가세요","5분 전","서울특별시 양천구","25,000원",2,1),
                Transaction(R.drawable.img_1246,"전각 긴급 처분합니다 새거에요","50분 전","서울특별시 은평구","55,000원",9,12),
                Transaction(R.drawable.img_1244,"쫄깃한 메밀소바 팝니다","3시간 전","서울특별시 관악구","95,000원",21,18),
                Transaction(R.drawable.img_1324,"제가 직접 쌓은 탑","8일 전","서울특별시 강남구","135,000원",37,53),
                Transaction(R.drawable.img_1648,"뜨끈한 라멘 식기 전에 가져가세요","5달 전","서울특별시 중랑구","385,000원",73,158),
                Transaction(R.drawable.img_1399,"외국에서 가져온 과자입니다 한입하세요","16년 전","서울특별시 중구","2,379,000원",99999,66666)
            )
        )
    }
}