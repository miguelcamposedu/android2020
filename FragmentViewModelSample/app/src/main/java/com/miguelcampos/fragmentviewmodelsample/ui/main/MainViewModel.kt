package com.miguelcampos.fragmentviewmodelsample.ui.main

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

    fun incrementCounter() {
        _counter.value = _counter.value?.plus(1)
    }

    fun decrementCounter() {
        _counter.value = _counter.value?.minus(1)
    }
}