package com.miguelcampos.listadoelementos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.miguelcampos.listadoelementos.R
import com.miguelcampos.listadoelementos.adapter.MyPokemonRecyclerViewAdapter
import com.miguelcampos.listadoelementos.poko.Pokemon
import com.miguelcampos.listadoelementos.viewmodel.PokemonListViewModel

class PokemonListFragment : Fragment() {

    var listaPokemon: List<Pokemon> = listOf()
    lateinit var listaAdapter: MyPokemonRecyclerViewAdapter
    lateinit var viewModel: PokemonListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        viewModel = ViewModelProvider(this).get(PokemonListViewModel::class.java)

        val v = view as RecyclerView

        listaAdapter = MyPokemonRecyclerViewAdapter(listaPokemon)
        v.layoutManager = LinearLayoutManager(context)
        v.adapter = listaAdapter

        viewModel.pokemon.observe(viewLifecycleOwner, Observer {
            pokemons -> listaPokemon = pokemons
            listaAdapter.setData(pokemons.sortedWith(compareBy({ it.name })))
        })


        return view
    }


}