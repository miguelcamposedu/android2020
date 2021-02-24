package com.miguelcampos.listadoelementos

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.miguelcampos.listadoelementos.poko.Restaurant

class MyRestauranteRecyclerViewAdapter(
    private val values: List<Restaurant>
) : RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_restaurante, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.text_view_name)
        val imageViewPhoto: ImageView = view.findViewById(R.id.image_view_restaurant)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentRestaurant = values[position]
        holder.textViewName.text = currentRestaurant.name
        holder.imageViewPhoto.load("http://img.recipepuppy.com/${currentRestaurant.photograph}")
    }



}