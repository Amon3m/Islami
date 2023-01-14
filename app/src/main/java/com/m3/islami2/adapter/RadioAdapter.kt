package com.m3.islami2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.m3.islami2.R
import com.m3.islami2.model.RadiosChannel

class RadioAdapter(var items:List<RadiosChannel?>?) : RecyclerView.Adapter<RadioAdapter.ViewHolder>(){


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title:TextView=itemView.findViewById(R.id.radio_title)
        val  play:ImageView=itemView.findViewById(R.id.play)
        val  stop:ImageView=itemView.findViewById(R.id.stop)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

       val view=LayoutInflater.from(parent.context)
           .inflate(R.layout.layout_channel,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position);
        holder.title.setText(item?.name)
        if (onPlayClickListener != null)
            holder.play.setOnClickListener {
                onPlayClickListener?.onItemClick(position, item!!)
            }

        if (onStopClickListener != null)
            holder.stop.setOnClickListener {
                onStopClickListener?.onItemClick(position, item!!)
            }

    }


    override fun getItemCount(): Int {
    return items?.size?:0
    }
    fun changeData(items:List<RadiosChannel?>?){
        this.items=items
        notifyDataSetChanged()
    }
    var onStopClickListener:OnItemClickListener?=null

    var onPlayClickListener:OnItemClickListener?=null
    interface OnItemClickListener{
        fun onItemClick(position: Int,radioUrl: RadiosChannel)
    }
}