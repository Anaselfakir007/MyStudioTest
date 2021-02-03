package com.mystudio.developerstestapp.adapters.developer

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mystudio.developerstestapp.data.response.DataDevelopers

class DeveloperAdapter(private val listener: DeveloperViewHolder.ViewListener? = null)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<DataDevelopers.DataDeveloper> = emptyList()
    fun setItems(items: List<DataDevelopers.DataDeveloper>) {
        this.items = items.sortedBy { it.name }
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DeveloperViewHolder.create(parent, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DeveloperViewHolder -> holder.bind(items[position])
        }
    }
}