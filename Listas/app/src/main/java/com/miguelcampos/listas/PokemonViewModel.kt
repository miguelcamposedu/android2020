package com.miguelcampos.listas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PokemonViewModel: ViewModel() {

    private val _pokemons = MutableLiveData<Int>()

    val counter: LiveData<Int>
        get() = _pokemons
}