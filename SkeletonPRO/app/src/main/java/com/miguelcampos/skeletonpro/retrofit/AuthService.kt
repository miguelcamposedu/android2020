package com.miguelcampos.skeletonpro.retrofit

import com.miguelcampos.skeletonpro.poko.LoginRequest
import com.miguelcampos.skeletonpro.poko.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("auth/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

}