package com.app.showme.Api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APICall {

    @GET("users")
    fun getAllUser(): Call<ResponseData>

    companion object Factory {
        private const val BASE_URL: String = "https://reqres.in/api/"

        fun create(): APICall {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(APICall::class.java)
        }
    }
}