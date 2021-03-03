package com.miguelcampos.skeletongrupo1.ui.pokemon

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.miguelcampos.skeletongrupo1.R
import com.miguelcampos.skeletongrupo1.ui.detail.DetallePokemonScrollingActivity

import com.miguelcampos.skeletongrupo1.ui.pokemon.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyPokemonRecyclerViewAdapter(
    private val activity: Context,
    private val values: List<DummyItem>
) : RecyclerView.Adapter<MyPokemonRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_pokemon, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content

        //TODO: evento click para mostrar el detalle de un elemento
        // de la lista
        holder.rootView.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, DetallePokemonScrollingActivity::class.java).apply {
                putExtra("pokemonId", item.id)
                putExtra("description", item.content)
            }
            activity.startActivity(intent)
        })
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rootView: View = view.findViewById(R.id.pokemon_view)
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}