package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.carrotmarket.databinding.FragmentHomeScrollBinding

class HomeScrollFragment : Fragment() {

    lateinit var binding : FragmentHomeScrollBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeScrollBinding.inflate(layoutInflater,container,false)

        binding.clItem1.setOnClickListener {
            val intent = Intent(requireContext(), StuffInfoActivity::class.java) // ::은 리플렉션이라고 함 왜 .java붙음?


            intent.apply {
                this.putExtra("key", 1)
                this.putExtra("picture",R.drawable.sonny)
                this.putExtra("price",binding.tvSonnyPrice.text)
            }

            startActivity(intent)
        }


        binding.clItem2.setOnClickListener {
            val intent = Intent(requireContext(), StuffInfoActivity::class.java) // ::은 리플렉션이라고 함 왜 .java붙음?


            intent.apply {
                this.putExtra("key", 1)
                this.putExtra("picture",R.drawable.maguia)
                this.putExtra("price",binding.tvMaguiaPrice.text)
            }

            startActivity(intent)
        }

        binding.clItem3.setOnClickListener {
            val intent = Intent(requireContext(), StuffInfoActivity::class.java) // ::은 리플렉션이라고 함 왜 .java붙음?

            intent.apply {
                intent.putExtra("key",0)
            }
            startActivity(intent)
        }
        return binding.root
    }


}