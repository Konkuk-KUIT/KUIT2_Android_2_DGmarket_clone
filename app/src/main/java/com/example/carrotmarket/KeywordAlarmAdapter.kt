package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemKeywordAlarmBinding

class KeywordAlarmAdapter(val keywordList : ArrayList<KeywordAlarmInfo>) : RecyclerView.Adapter<KeywordAlarmAdapter.ViewHolder>() {

    inner class ViewHolder(val binding : ItemKeywordAlarmBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(keywordInfo : KeywordAlarmInfo){
            binding.tvKeywordAlarmTitle.text = keywordInfo.keywordAlarmTitle
            binding.tvKeywordAlarmMeet.text = keywordInfo.keywordAlarmMeet
            binding.tvKeywordAlarmTime.text = keywordInfo.keywordAlarmTime
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): KeywordAlarmAdapter.ViewHolder {
        val binding = ItemKeywordAlarmBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: KeywordAlarmAdapter.ViewHolder, position: Int) {
        holder.bind(keywordList[position])
    }

    override fun getItemCount(): Int = keywordList.size
}