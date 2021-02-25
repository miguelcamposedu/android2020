package com.miguelcampos.listadoelementos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.miguelcampos.listadoelementos.poko.Pokemon
import com.miguelcampos.listadoelementos.poko.PokemonAllResponse
import com.miguelcampos.listadoelementos.retrofit.PokemonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.HTTP

class PokemonListViewModel: ViewModel() {

    private val _pokemons = MutableLiveData<List<Pokemon>>()
    private val baseUrl = "https://pokeapi.co/api/v2/"
    private lateinit var service: PokemonService


    val pokemon: LiveData<List<Pokemon>>
        get() = _pokemons

    init {
        _pokemons.value = listOf()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(PokemonService::class.java)
        getPokemonList()
    }

    fun getPokemonList() {
        service.getPokemonList("0","100").enqueue(object: Callback<PokemonAllResponse> {
            override fun onResponse(
                call: Call<PokemonAllResponse>,
                response: Response<PokemonAllResponse>
            ) {
                if(response.code() == 200) {
                    _pokemons.value = response.body()?.results
                }
            }

            override fun onFailure(call: Call<PokemonAllResponse>, t: Throwable) {
                // Entra cuando falla la comunicación con el servidor
            }
        })
    }
}