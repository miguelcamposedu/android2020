package com.miguelcampos.basketmarcador.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.miguelcampos.basketmarcador.R
import com.miguelcampos.basketmarcador.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    lateinit var binding: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)


        binding.buttonAdd1.setOnClickListener{
            updateMarcador(1)
        }

        binding.buttonAdd2.setOnClickListener{
            updateMarcador(2)
        }

        binding.buttonAdd3.setOnClickListener{
            updateMarcador(3)
        }

        return binding.root
    }

    private fun updateMarcador(inc: Int) {
        viewModel.incrementCounter(inc)
        binding.textViewMarcadorLocal.text = viewModel.counter.value.toString()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.counter.observe(viewLifecycleOwner, Observer {
            nuevoValorCounter ->
            Toast.makeText(
                activity,
                "Counter $nuevoValorCounter",
                Toast.LENGTH_LONG).show()
        })
    }

}