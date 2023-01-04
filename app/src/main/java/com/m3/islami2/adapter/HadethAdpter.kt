package com.m3.islami2.adapter

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m3.islami2.R
import com.m3.islami2.databinding.FragmentHadethBinding
import com.m3.islami2.databinding.ItemHadethBinding
import com.m3.islami2.model.HadethModel


class HadethAdpter(val items:List<HadethModel>): RecyclerView.Adapter<HadethAdpter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hadethName: TextView = itemView.findViewById(R.id.hadeth_name)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hadeth, parent, false)
        return ViewHolder(view)

    }


    override fun getItemCount(): Int {

        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Hadeth = items[position]
        holder.hadethName.setText(Hadeth.title)
        if (onItemsClickListener != null) {
            holder.itemView.setOnClickListener(View.OnClickListener {
                onItemsClickListener?.OnItemsClick(position, Hadeth)
            })
        }
    }


    var onItemsClickListener: OnItemsClickListener? = null

    interface OnItemsClickListener {

        fun OnItemsClick(position: Int, model:HadethModel)
    }
}