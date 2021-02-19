package com.miguelcampos.basketmarcador.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _counter = MutableLiveData<Int>()

    val counter: LiveData<Int>
        get() = _counter

    init {
        _counter.value = 0
    }

    fun incrementCounter(inc: Int) {
        _counter.value = _counter.value?.plus(inc)
        Log.i("APP", "Valor ${_counter.value}")
    }
}