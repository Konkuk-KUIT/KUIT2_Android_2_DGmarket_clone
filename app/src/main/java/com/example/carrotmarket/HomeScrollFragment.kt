package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.DataClass.Product
import com.example.carrotmarket.databinding.FragmentHomeScrollBinding

class HomeScrollFragment : Fragment(){

    lateinit var binding : FragmentHomeScrollBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeScrollBinding.inflate(layoutInflater,container,false)

        val product_list = ArrayList<Product>()
        product_list.add(
            Product(
            R.drawable.sonny,
            "토트넘의 수장! 손흥민",
            "토트넘",
            "700억",
            99,
            99
            )
        )
        product_list.add(Product(
            R.drawable.maguia,
            "맨유 수비 전설! 매과이어",
            "맨유",
            "1억",
            14,
            1
        ))
        product_list.add(Product(
            R.drawable.hoil,
            "크패전 잘봤다 일룬아",
            "맨유",
            "400억",
            9,
            14
        ))

        product_list.add(Product(
            R.drawable.ohnana,
            "오나나나",
            "맨유",
            "356억",
            9,
            14
        ))

        product_list.add(Product(
            R.drawable.minjae,
            "뮌헨 이적 김민재!",
            "바이에른뮌헨",
            "800억",
            23,
            88
        ))

        product_list.add(Product(
            R.drawable.roise,
            "로이스",
            "도르트문트",
            "600억",
            7,
            3
        ))

        product_list.add(Product(
            R.drawable.roise,
            "로이스",
            "도르트문트",
            "600억",
            7,
            3
        ))

        product_list.add(Product(
            R.drawable.roise,
            "로이스",
            "도르트문트",
            "600억",
            7,
            3
        ))

        product_list.add(Product(
            R.drawable.roise,
            "로이스",
            "도르트문트",
            "600억",
            7,
            3
        ))

        val productAdapter = ProductAdapter(product_list)
        binding.rvProductList.adapter = productAdapter
        binding.rvProductList.layoutManager = LinearLayoutManager(requireContext())

        productAdapter.setOnItemClickListener(object : ProductAdapter.OnItemClickListener{
            override fun onItemClick(product: Product) {
                val intent = Intent(requireContext(), StuffInfoActivity::class.java)
                intent.putExtra("product_data",product)
                startActivity(intent)
            }

        })


        return binding.root
    }


}