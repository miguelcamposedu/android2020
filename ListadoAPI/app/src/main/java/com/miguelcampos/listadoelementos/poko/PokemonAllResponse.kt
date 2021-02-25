package com.miguelcampos.listadoelementos.poko

data class PokemonAllResponse(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Pokemon>
)