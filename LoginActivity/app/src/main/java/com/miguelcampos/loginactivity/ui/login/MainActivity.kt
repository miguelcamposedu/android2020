package com.miguelcampos.loginactivity.ui.login

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.miguelcampos.loginactivity.R
import com.miguelcampos.loginactivity.poko.LoginRequest
import com.miguelcampos.loginactivity.poko.LoginResponse
import com.miguelcampos.loginactivity.retrofit.AuthService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var baseUrl = "https://www.minitwitter.com:3001/apiv1/"
    lateinit var retrofit: Retrofit
    lateinit var service: AuthService
    val context = this

    lateinit var btnLogin: Button
    lateinit var editTextEmail: EditText
    lateinit var editTextPass: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.button_login)
        editTextEmail = findViewById(R.id.edit_text_email)
        editTextPass = findViewById(R.id.edit_text_password)

        supportActionBar?.hide()

        retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(AuthService::class.java)

        btnLogin.setOnClickListener(View.OnClickListener {
            doLogin()
        })

    }

    fun doLogin() {

        val loginData = LoginRequest(editTextEmail.text.toString(), editTextPass.text.toString())

        service.login(loginData).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                if(response.code() == 200) {
                    //TODO Guardar el token
                    val sharedPref =
                        context.getSharedPreferences("FILE_PREFERENCES", Context.MODE_PRIVATE)
                        with(sharedPref.edit()) {
                            putString("TOKEN", response.body()?.token)
                            commit()
                        }

                    Log.i("MIGUEL", response.body()?.token)

                } else {
                    Log.i("MIGUEL", "Login incorrecto")
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.i("MIGUEL", "Error")
            }
        })
    }

}