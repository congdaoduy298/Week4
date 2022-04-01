package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.login.Res
import com.example.login.MainViewModel


class RestaurantAdapter(var dataSet: List<Res>): RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {
    class RestaurantViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        companion object{

            fun from (parent: ViewGroup):RestaurantViewHolder{

                val layoutInflater=LayoutInflater.from(parent.context)
                val view=layoutInflater.inflate(R.layout.card_view,parent,false)
                return RestaurantViewHolder(view)
            }

        }
        fun bindData(res: Res){
            val name=itemView.findViewById<TextView>(R.id.nameRes)
            val address=itemView.findViewById<TextView>(R.id.addRes)
            val ava=itemView.findViewById<ImageView>(R.id.imRes)
            name.text=res.name
            address.text=res.addr
            Glide.with(ava).load(res.avatar.toString()).into(ava)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val res = dataSet[position]
        holder.bindData(res)
    }


    override fun getItemCount(): Int {
        return dataSet.size
    }

}