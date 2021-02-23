package com.miguelcampos.miprimeralista

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.miguelcampos.miprimeralista.dummy.DummyContent

/**
 * A fragment representing a list of Items.
 */
class AlumnoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_alumno_list, container, false)

        var pokemonList = mutableListOf<Pokemon>(
            Pokemon(),
            Pokemon()
        )

        // Set the adapter
        with(view as RecyclerView) {
            layoutManager = LinearLayoutManager(context)
            adapter = MyAlumnoRecyclerViewAdapter(pokemonList)
        }
        return view
    }
}