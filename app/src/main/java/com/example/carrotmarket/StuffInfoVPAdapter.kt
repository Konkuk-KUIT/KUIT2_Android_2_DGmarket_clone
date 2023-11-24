package com.example.carrotmarket

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.databinding.ItemImageInfoBinding

class StuffInfoVPAdapter(val context : Context, val imgList : MutableList<String>) : RecyclerView.Adapter<StuffInfoVPAdapter.ViewHolder>() {

    inner class ViewHolder(val binding : ItemImageInfoBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(imgUrl : String) {
            Glide.with(context)
                .load(imgUrl)
                .into(binding.itemIv)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemImageInfoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imgList[position])
    }

    override fun getItemCount(): Int = imgList.size
}