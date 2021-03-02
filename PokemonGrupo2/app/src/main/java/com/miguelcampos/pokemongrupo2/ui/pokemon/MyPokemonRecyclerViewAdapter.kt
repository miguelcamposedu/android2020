package com.miguelcampos.pokemongrupo2.ui.pokemon

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.miguelcampos.pokemongrupo2.R
import com.miguelcampos.pokemongrupo2.poko.Pokemon

class MyPokemonRecyclerViewAdapter(
    private var values: List<Pokemon>
) : RecyclerView.Adapter<MyPokemonRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        val id = item.url.reversed().split("/")[1].reversed()
        holder.textViewName.text = item.name
        holder.imageViewAvatar.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png")
    }

    override fun getItemCount(): Int = values.size

    fun setData(listaNueva: List<Pokemon>?) {
        if (listaNueva != null) {
            values = listaNueva
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewName: TextView = view.findViewById(R.id.text_view_name)
        val imageViewAvatar: ImageView = view.findViewById(R.id.image_view_avatar)
    }
}