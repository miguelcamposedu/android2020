package com.miguelcampos.a06_calculadora

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class CalculadoraFragment : Fragment(), View.OnClickListener {
    var isHappy = true
    lateinit var tvEight : TextView
    lateinit var tvNine: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var v = inflater.inflate(R.layout.fragment_calculadora, container, false)

        tvEight = v.findViewById(R.id.text_view_8)
        tvNine = v.findViewById(R.id.text_view_9)

        this.tvEight.setOnClickListener(this)
        this.tvNine.setOnClickListener(this)

        /*v.findViewById<TextView>(R.id.text_view_9).setOnClickListener {
            view ->
            Snackbar.make(view, "Has hecho click en 9", Snackbar.LENGTH_LONG).show()
            (view as TextView).text = if(isHappy) ";)"  else ":("
            isHappy = !isHappy
        }*/

        return v
    }

    override fun onClick(v: View?) {
        val id = v?.id
        if(id == R.id.text_view_8)
            Toast.makeText(activity, "Has pulsado el botón 8", Toast.LENGTH_LONG).show()
        else if (id == R.id.text_view_9)
            Toast.makeText(activity, "Has pulsado el botón 9", Toast.LENGTH_LONG).show()
    }

}