package com.miguelcampos.pokemongrupo2.ui.pokemon

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miguelcampos.pokemongrupo2.poko.Pokemon
import com.miguelcampos.pokemongrupo2.poko.PokemonResponse
import com.miguelcampos.pokemongrupo2.retrofit.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonViewModel: ViewModel() {
    var baseUrl = "https://pokeapi.co/api/v2/"
    var retrofit: Retrofit
    var pokemonService: PokemonService

    private var _pokemons = MutableLiveData<List<Pokemon>>()

    val pokemons: LiveData<List<Pokemon>>
        get() = _pokemons

    init {
        _pokemons.value = listOf()
        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        pokemonService = retrofit.create(PokemonService::class.java)
        getPokemons()
    }

    private fun getPokemons() {
        pokemonService.getPokemonList(0, 100).enqueue(object: Callback<PokemonResponse> {
            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                if(response.code() == 200) {
                    _pokemons.value = response.body()?.results
                }
            }
            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                Log.i("MIGUEL","ha entrado en onFailure")
            }
        })
    }

}