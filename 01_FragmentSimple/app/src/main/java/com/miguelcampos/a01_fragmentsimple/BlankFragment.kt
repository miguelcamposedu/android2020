package com.miguelcampos.a01_fragmentsimple

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class BlankFragment : Fragment(), View.OnClickListener {
    val title: TextView? = null
    var textoPantalla: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var v: View = inflater.inflate(R.layout.fragment_blank, container, false)
        title = v.findViewById(R.id.text_view_ejemplo)
        var title2: TextView = v.findViewById(R.id.text_view_ejemplo2)

        title.text = "Este es el Blank Fragment"
        /*title.setOnClickListener{
            view -> Snackbar
            .make(view, "Has pulsado en título ${title.text}", Snackbar.LENGTH_LONG)
            .show()
        }*/

        title.setOnClickListener(this)
        title2.setOnClickListener(this)
        return v
    }

    override fun onClick(v: View?) {
        var texto = (v as TextView).text
        Snackbar
            .make(v, "Has pulsado en título ${texto}", Snackbar.LENGTH_LONG)
            .show()
    }


}