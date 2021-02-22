package com.miguelcampos.fragmentviewmodelsample.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.miguelcampos.fragmentviewmodelsample.R
import com.miguelcampos.fragmentviewmodelsample.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }
    
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        initValues()
        initEvents()

        return binding.root
    }

    private fun initEvents() {
        binding.buttonMinus.setOnClickListener {
            viewModel.decrementCounter()
        }

        binding.buttonPlus.setOnClickListener {
            viewModel.incrementCounter()
        }
    }

    private fun initValues() {
        binding.canMinus = false
        binding.canPlus = true
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.counter.observe(viewLifecycleOwner, Observer {
            // nuevoValorContador -> binding.textViewCounter.text = nuevoValorContador.toString()
            nuevoValorContador -> binding.contador = nuevoValorContador.toString()
            when(nuevoValorContador) {
                0 -> {
                    binding.canMinus = false
                } else -> binding.canMinus = true
            }
        })
    }

}