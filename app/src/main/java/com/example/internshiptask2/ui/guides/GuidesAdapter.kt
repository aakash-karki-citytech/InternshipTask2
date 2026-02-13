package com.example.internshiptask2.ui.guides

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.internshiptask2.data.model.User
import com.example.internshiptask2.databinding.ItemGuideBinding

class GuidesAdapter(private val list: List<User>, private val listener: GuidesClickListener) :
    RecyclerView.Adapter<GuidesAdapter.GuideViewHolder>() {

    inner class GuideViewHolder(val binding: ItemGuideBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuideViewHolder {
        val binding = ItemGuideBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuideViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuideViewHolder, position: Int) {
        val user = list[position]

        holder.binding.tvUsername.text = user.login
        holder.binding.tvUsername.setOnClickListener { listener.onEdit() }

        Glide.with(holder.itemView.context)
            .load(user.avatarUrl)
            .circleCrop()
            .into(holder.binding.ivAvatar)


        holder.binding.ivAvatar.setOnClickListener { listener.onDelete() }

    }

    override fun getItemCount(): Int = list.size
}

interface GuidesClickListener{

    fun onEdit()
    fun onDelete()

}
