package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemExerciseAlarmBinding

class ExerciseAlarmAdapter(val exerciseList : ArrayList<ExerciseAlarmDataClass>) : RecyclerView.Adapter<ExerciseAlarmAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemExerciseAlarmBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(exerciseInfo : ExerciseAlarmDataClass){
            binding.tvExerciseAlarmTitle.text = exerciseInfo.exerciseAlarmTitle
            binding.tvExerciseAlarmMeet.text = exerciseInfo.exerciseAlarmMeet
            binding.tvExerciseAlarmTime.text = exerciseInfo.exerciseAlarmTime
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseAlarmAdapter.ViewHolder {
        val binding = ItemExerciseAlarmBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExerciseAlarmAdapter.ViewHolder, position: Int) {
        holder.bind(exerciseList[position])
    }

    override fun getItemCount(): Int = exerciseList.size

}