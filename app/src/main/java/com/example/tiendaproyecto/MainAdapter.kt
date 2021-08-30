package com.example.tiendaproyecto

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_row.view.*

class MainAdapter(private val context:Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<Producto>()

    fun setListData(data:MutableList<Producto>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (dataList.size > 0) {
            dataList.size
        }else{
            0
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val producto: Producto = dataList[position]
        holder.bindView(producto)
    }

    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bindView(producto: Producto){
            Glide.with(context).load(producto.imageUrl).into(itemView.ImageView)
            itemView.txt_title.text = producto.nombre
            itemView.txt_desc.text = producto.descripcion
            itemView.txt_price.text = producto.precio
        }
    }
}