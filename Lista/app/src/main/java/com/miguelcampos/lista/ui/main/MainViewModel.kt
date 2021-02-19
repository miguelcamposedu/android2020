package com.miguelcampos.lista.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private val _puntos = MutableLiveData<Int>()
    val puntos: LiveData<Int>
        get() = _puntos

    init {
        _puntos.value = 0
    }

    fun add() {
        _puntos.value = (_puntos.value)?.plus(1)
    }
}