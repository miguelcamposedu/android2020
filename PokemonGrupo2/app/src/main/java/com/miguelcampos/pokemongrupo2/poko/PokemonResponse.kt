package com.miguelcampos.pokemongrupo2.poko

data class PokemonResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)