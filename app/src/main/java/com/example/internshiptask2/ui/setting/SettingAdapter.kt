package com.example.internshiptask2.ui.settings

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.internshiptask2.data.local.entity.SettingEntity
import com.example.internshiptask2.databinding.ItemSettingBinding

class SettingAdapter(
    private var list: List<SettingEntity>
) : RecyclerView.Adapter<SettingAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemSettingBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSettingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.binding.tvTitle.text = item.title
        holder.binding.tvValue.text = item.value
    }

    override fun getItemCount(): Int = list.size

    fun updateData(newList: List<SettingEntity>) {
        list = newList
        notifyDataSetChanged()
    }
}
