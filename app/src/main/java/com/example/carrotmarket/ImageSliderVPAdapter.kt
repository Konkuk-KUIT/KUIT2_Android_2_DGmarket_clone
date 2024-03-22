package com.example.carrotmarket

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.databinding.ItemDetailImageBinding

class ImageSliderVPAdapter(val context: Context, val imgList: MutableList<String>) : RecyclerView.Adapter<ImageSliderVPAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemDetailImageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imgUrl: String){
            Glide.with(context).load(imgUrl).into(binding.itemDetailIv)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDetailImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = imgList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imgList[position])
    }
}