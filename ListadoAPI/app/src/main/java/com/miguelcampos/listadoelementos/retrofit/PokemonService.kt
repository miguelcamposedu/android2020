package com.miguelcampos.listadoelementos.retrofit

import com.miguelcampos.listadoelementos.poko.PokemonAllResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {

    @GET("pokemon")
    fun getPokemonList(@Query("offset") paramOffset : String,
                       @Query("limit") paramLimit: String) : Call<PokemonAllResponse>
}