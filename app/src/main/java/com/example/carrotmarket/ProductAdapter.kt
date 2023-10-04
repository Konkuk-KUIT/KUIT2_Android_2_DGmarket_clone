package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemHomeProductBinding

class ProductAdapter(val transList: ArrayList<Transaction>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener
    interface OnItemClickListener{
        fun onItemClick(myTrans: Transaction)
    }

    inner class ViewHolder(val binding: ItemHomeProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(myTrans: Transaction){
            binding.ivItemHomeThumnail.setImageResource(myTrans.trans_img)
            binding.tvItemHomeTitle.text=myTrans.trans_title
            binding.tvItemHomePos.text=myTrans.trans_pos
            binding.tvItemHomeTimeline.text=myTrans.trans_timeline
            binding.tvItemHomePrice.text=myTrans.trans_price
            binding.tvItemHomeComment.text=myTrans.trans_comment_count.toString()
            binding.tvItemHomeLike.text=myTrans.trans_like_count.toString()
            binding.ivItemHomeAll.setOnClickListener {
                itemClickListener.onItemClick(myTrans)
            }
        }
    }

    fun setOnItemClickListener(onItemClickLister: OnItemClickListener){
        itemClickListener=onItemClickLister
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = transList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(transList[position])
    }
}