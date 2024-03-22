package com.example.carrotmarket

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

class AlarmSliderVPAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ExerciseAlarmFragment()
            else -> KeywordAlarmFragment()
        }
    }

}

/*class AlarmSliderVPAdapter(val context: Context, val alarmList: MutableList<String>) : RecyclerView.Adapter<AlarmSliderVPAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: FragmentAlarmInnerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imgUrl: String){

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FragmentAlarmInnerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = alarmList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(alarmList[position])
    }
}*/