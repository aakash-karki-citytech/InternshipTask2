package com.example.internshiptask2.ui.home
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.internshiptask2.data.model.HeritageSite
import com.example.internshiptask2.databinding.ItemHeritageBinding



class HeritageAdapter(
    private val list: List<HeritageSite>
) : RecyclerView.Adapter<HeritageAdapter.HeritageViewHolder>() {

    inner class HeritageViewHolder(val binding: ItemHeritageBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeritageViewHolder {
        val binding = ItemHeritageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HeritageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeritageViewHolder, position: Int) {
        val item = list[position]

        Glide.with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.binding.ivImage)

        holder.binding.tvName.text = item.name
        holder.binding.tvDescription.text = item.description
        holder.binding.tvLocation.text = item.location
    }

    override fun getItemCount(): Int = list.size
}