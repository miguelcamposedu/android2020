package com.miguelcampos.pokemongrupo2.ui.pokemon

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.miguelcampos.pokemongrupo2.R
import com.miguelcampos.pokemongrupo2.poko.Pokemon


class PokemonFragment : Fragment() {

    lateinit var pokemonList: List<Pokemon>
    lateinit var adapterPokemon: MyPokemonRecyclerViewAdapter
    lateinit var viewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pokemon_list, container, false)

        viewModel = ViewModelProvider(this).get(PokemonViewModel::class.java)

        pokemonList = listOf()
        adapterPokemon = MyPokemonRecyclerViewAdapter(pokemonList)

        with(view as RecyclerView) {
            layoutManager =  LinearLayoutManager(context)
            adapter = adapterPokemon
        }

        viewModel.pokemons.observe(viewLifecycleOwner, Observer {
            listaNueva -> pokemonList = listaNueva
            adapterPokemon.setData(listaNueva)
        })


        return view
    }


}