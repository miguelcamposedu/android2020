package com.miguelcampos.skeletongrupo1.ui.detail

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.miguelcampos.skeletongrupo1.R

class DetallePokemonScrollingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pokemon_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))
        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = title
        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        //TODO rescato el valor de pokemonId que recibo del Intent

        val idPokemon = intent.extras?.getString("pokemonId")
        val pokemonDescription = intent.extras?.getString("description")
        Toast.makeText(this, "Pokemon ID: ${idPokemon}", Toast.LENGTH_SHORT).show()

        findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout).title = pokemonDescription

    }
}