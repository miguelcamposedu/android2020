package com.miguelcampos.skeletonpro.ui.login

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.miguelcampos.skeletonpro.MainActivity
import com.miguelcampos.skeletonpro.R
import com.miguelcampos.skeletonpro.poko.LoginRequest
import com.miguelcampos.skeletonpro.poko.LoginResponse
import com.miguelcampos.skeletonpro.retrofit.AuthService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    lateinit var etEmail: EditText
    lateinit var etPass: EditText
    lateinit var btnLogin: Button


    val baseUrl = "https://www.minitwitter.com:3001/apiv1/"
    lateinit var retrofit: Retrofit
    lateinit var service: AuthService
    lateinit var ctx: Context
    lateinit var token: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //TODO con la siguiente línea oculto el toolbar en esta pantalla
        actionBar?.hide()

        init()
        events()

    }

    private fun events() {
        btnLogin.setOnClickListener(View.OnClickListener {
            //TODO con las 2 siguiente líneas hacéis magiè y lanzáis
            // el Activity que indiquéis en el 2º parámetro.

            val email = etEmail.text.toString()
            val password = etPass.text.toString()

            if(email.isNotBlank() && password.isNotBlank()) {
                service.login(LoginRequest(email, password)).enqueue(object: Callback<LoginResponse>{
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        if(response.code() == 200) {
                            val sharedPref = ctx?.getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

                            token = response.body()?.token!!

                            with(sharedPref.edit()) {
                                putString("TOKEN", response.body()?.token)
                                commit()
                            }

                            // Limpiar el formulario
                            etEmail.text.clear()
                            etPass.text.clear()

                            val intent = Intent(ctx, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Log.i("APP", "Error en petición de login")
                    }
                })
            } else {
                etEmail.error = "Email incorrecto"
                etPass.error = "Password incorrecto"
            }




        })
    }

    private fun init() {
        etEmail = findViewById(R.id.edit_text_email)
        etPass = findViewById(R.id.edit_text_password)
        btnLogin = findViewById(R.id.button_login)

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(AuthService::class.java)

        ctx = this

    }

}