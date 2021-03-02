package com.miguelcampos.pokemongrupo2.retrofit

import com.miguelcampos.pokemongrupo2.poko.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    fun getPokemonList(@Query("offset") pageOffset: Number,
                       @Query("limit") pageLimit: Number): Call<PokemonResponse>


}