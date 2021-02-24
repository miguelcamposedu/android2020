package com.miguelcampos.listadoelementos

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miguelcampos.listadoelementos.poko.Restaurant

class RestauranteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_restaurante_list, container, false)

        val listaRestaurantes = mutableListOf<Restaurant>(
            Restaurant("Goiko", "5.jpg")
        )

        with(view as RecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyRestauranteRecyclerViewAdapter(listaRestaurantes)
        }
        return view
    }


}