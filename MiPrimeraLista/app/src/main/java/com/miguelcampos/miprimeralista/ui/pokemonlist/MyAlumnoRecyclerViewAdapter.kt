package com.miguelcampos.miprimeralista.ui.pokemonlist

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import coil.load
import com.miguelcampos.miprimeralista.R
import com.miguelcampos.miprimeralista.poko.Pokemon


class MyAlumnoRecyclerViewAdapter(
    private val values: List<Pokemon>
) : RecyclerView.Adapter<MyAlumnoRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_alumno, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.nombreView.text = item.name
        holder.avatarView.load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${item.url}.png")
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreView: TextView = view.findViewById(R.id.text_view_nombre)
        val avatarView: ImageView = view.findViewById(R.id.image_view_avatar)
    }
}