package com.m3.islami2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m3.islami2.R

class AyaAdapter(val items:List<String>) : RecyclerView.Adapter<AyaAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val aya:TextView=itemView.findViewById(R.id.aya)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       val view=LayoutInflater.from(parent.context)
           .inflate(R.layout.item_aya,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val aya = items[position]
            holder.aya.setText(aya+" "+"["+(position+1)+"]")

    }

    override fun getItemCount(): Int {
    return items.size
    }
}