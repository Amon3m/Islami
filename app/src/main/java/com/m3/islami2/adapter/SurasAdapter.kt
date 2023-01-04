package com.m3.islami2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m3.islami2.R

class SurasAdapter( val items:List<String>) :RecyclerView.Adapter<SurasAdapter.ViewHolder>(){



    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){

       val suraName:TextView=itemView.findViewById(R.id.sura_name)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sura,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val SuraName=items[position]
        holder.suraName.text = SuraName //

        if (onItemsClickListener!=null){
        holder.itemView.setOnClickListener(View.OnClickListener {
            onItemsClickListener?.OnItemsClick(position,SuraName )
        })
    }}
    var onItemsClickListener: OnItemsClickListener?=null
    interface OnItemsClickListener{

       fun OnItemsClick(position: Int,name:String)
    }
    override fun getItemCount(): Int {
        return items.size
    }
}