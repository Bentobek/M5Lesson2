package com.example.m5lesson2.data.retrofit

import com.example.m5lesson2.data.model.CharacterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    fun getCharacters(
        @Query("page") page: Int
    ): CharacterResponse
}
