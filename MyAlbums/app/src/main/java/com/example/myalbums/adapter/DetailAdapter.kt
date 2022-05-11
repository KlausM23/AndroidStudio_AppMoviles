package com.example.myalbums.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myalbums.R
import com.example.myalbums.entity.Detail

class DetailAdapter (val detail: Detail): RecyclerView.Adapter<DetailPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_album, parent, false)

        return DetailPrototype(view)
    }

    override fun onBindViewHolder(holder: DetailPrototype, position: Int) {
        holder.bind(detail)
    }

    override fun getItemCount(): Int {
        return 1
    }
}

class DetailPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvUId = itemView.findViewById<TextView>(R.id.tvUId)
    val tvId = itemView.findViewById<TextView>(R.id.tvId)
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)

    @SuppressLint("SetTextI18n")
    fun bind(detail: Detail){
        tvUId.text = "userId: " + detail.userId.toString()
        tvId.text = "id: " + detail.id.toString()
        tvTitle.text = "title: " + detail.title
    }
}
