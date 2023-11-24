package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemHomeProductBinding

class ProductAdapter(val productList : ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var itemClickListener : OnItemClickListener
    interface OnItemClickListener{
        fun onItemClick(product: Product)
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener){
        this.itemClickListener = itemClickListener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductAdapter.ViewHolder {
        val binding = ItemHomeProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        // 뷰 홀더 생성
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.ViewHolder, position: Int) {
        holder.bind(productList[position])
        val binding = holder.binding
        binding.homeProduct1.setOnClickListener{
            itemClickListener.onItemClick(productList[position])
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ViewHolder(val binding : ItemHomeProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(product: Product){
            binding.ivProductPicture.setImageResource(product.product_img)
            binding.tvProductTitle.text = product.product_title
            binding.tvProductAddress.text = product.product_address
            binding.tvProductPrice.text = product.product_price
            binding.tvItemHomeComment.text = product.comment_count.toString()
            binding.tvItemHomeLike.text = product.like_count.toString()

            binding.homeProduct1.setOnClickListener{
                itemClickListener.onItemClick(product)
            }
        }

    }


}