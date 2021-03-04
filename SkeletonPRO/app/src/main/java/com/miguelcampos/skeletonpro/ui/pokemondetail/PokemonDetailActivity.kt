package com.miguelcampos.skeletonpro.ui.pokemondetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miguelcampos.skeletonpro.R

class PokemonDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_detail)

        //TODO rescato los parámetros que me han pasado en el objeto Intent

        val id = intent.extras?.getString(getString(R.string.extra_id))
        val content = intent.extras?.getString(getString(R.string.extra_name))
        val edad = intent.extras?.getInt(getString(R.string.extra_edad))

        //TODO Setear los valores en la IU
        title = content

    }
}