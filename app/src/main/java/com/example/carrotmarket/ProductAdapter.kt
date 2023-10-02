package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemHomeProductBinding

class ProductAdapter(val productList: ArrayList<ProductInfo>):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(productInfo: ProductInfo)
    }
    inner class ViewHolder(val binding: ItemHomeProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(productInfo: ProductInfo){
            binding.ivItemThumbnail.setImageResource(productInfo.productImage)
            binding.tvProductPrice.text = productInfo.productPrice
            binding.tvProductTitle.text = productInfo.productTitle
            binding.tvProductLocation.text = productInfo.productLocation
            binding.clItem.setOnClickListener {
                itemClickListener.onItemClick(productInfo)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val binding = ItemHomeProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    fun setOnItemClickListener(onItemClickListener : OnItemClickListener){
        itemClickListener = onItemClickListener
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int = productList.size
}