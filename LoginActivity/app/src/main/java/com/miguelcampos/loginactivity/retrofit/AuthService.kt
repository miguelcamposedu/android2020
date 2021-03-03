package com.miguelcampos.loginactivity.retrofit

import com.miguelcampos.loginactivity.poko.LoginRequest
import com.miguelcampos.loginactivity.poko.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthService {

    @POST("auth/login")
    fun login(@Body requestLogin: LoginRequest): Call<LoginResponse>
}