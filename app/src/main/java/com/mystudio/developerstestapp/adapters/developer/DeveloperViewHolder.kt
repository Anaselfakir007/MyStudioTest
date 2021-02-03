package com.mystudio.developerstestapp.adapters.developer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mystudio.developerstestapp.R
import com.mystudio.developerstestapp.data.response.DataDevelopers
import kotlinx.android.synthetic.main.view_developer.view.*

class DeveloperViewHolder(view: View, val listener: ViewListener? = null) :
    RecyclerView.ViewHolder(view) {
    companion object {
        fun create(parent: ViewGroup, listener: ViewListener? = null) = DeveloperViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_developer,
                parent,
                false
            ), listener
        )
    }

    fun bind(item: DataDevelopers.DataDeveloper) {
        itemView.developerContainer.setOnClickListener { listener?.onDeveloperClicked(item) }
        Glide.with(itemView.context).load(item.picture).centerCrop().into(itemView.itemImage)
        itemView.itemName.text = item.name

    }

    interface ViewListener {
        fun onDeveloperClicked(item: DataDevelopers.DataDeveloper)
    }


}