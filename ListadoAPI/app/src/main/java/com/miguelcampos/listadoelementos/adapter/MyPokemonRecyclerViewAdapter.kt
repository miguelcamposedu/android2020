package com.miguelcampos.listadoelementos.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.miguelcampos.listadoelementos.R
import com.miguelcampos.listadoelementos.poko.Pokemon

class MyPokemonRecyclerViewAdapter(
    private var values: List<Pokemon>
) : RecyclerView.Adapter<MyPokemonRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_pokemon, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewId: TextView = view.findViewById(R.id.text_view_id)
        val textViewName: TextView = view.findViewById(R.id.text_view_name)
        val imageViewPhoto: ImageView = view.findViewById(R.id.image_view_restaurant)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = values[position]
        val id = currentItem.url.reversed().split("/")[1].reversed()
        holder.textViewId.text = id
        holder.textViewName.text = currentItem.name.capitalize()
        holder.imageViewPhoto.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png")
    }

    fun setData(newPokemons: List<Pokemon>) {
       this.values = newPokemons
        // Refresca la IU para que se muestren los nuevos
        // Pokemon en la lista
        notifyDataSetChanged()
    }



}