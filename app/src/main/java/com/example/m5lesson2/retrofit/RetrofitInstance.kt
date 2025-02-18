package com.example.m5lesson2.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://rickandmortyapi.com/api/")
        .build()

    val api: ApiService = retrofit.create(ApiService::class.java)
}