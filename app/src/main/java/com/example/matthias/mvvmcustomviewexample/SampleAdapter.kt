package com.example.matthias.mvvmcustomviewexample

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class SampleAdapter: RecyclerView.Adapter<SampleAdapter.ViewHolder>() {
    var items: List<String> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = items[position].let {
        holder.bind(it)
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(title: String) {
            println(title)
        }
    }
}