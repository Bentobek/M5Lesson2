package com.example.m5lesson2.retrofit

import com.example.m5lesson2.model.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    fun getCharacters(): Call<CharacterResponse>
}