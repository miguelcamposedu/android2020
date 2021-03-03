package com.miguelcampos.loginactivity.retrofit

import com.miguelcampos.loginactivity.poko.TweetResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface TweetService {
    @GET()
    fun getTweetList(@Header("Authorization Bearer: ") token: String): Call<TweetResponse>
}