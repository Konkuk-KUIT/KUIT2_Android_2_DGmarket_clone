package com.example.carrotmarket

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.databinding.SuffProductImageBinding

class SuffProductImgSliderVPAdapter(val context: Context, val suff_product_imgList:MutableList<String>)
    : RecyclerView.Adapter<SuffProductImgSliderVPAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: SuffProductImageBinding) : RecyclerView.ViewHolder(binding.root){
            fun bind(imgUrl:String){
                Glide.with(context)
                    .load(imgUrl)
                    .into(binding.suffProductImageIv)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SuffProductImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = suff_product_imgList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(suff_product_imgList[position])
    }
}