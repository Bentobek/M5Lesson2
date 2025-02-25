package com.example.m5lesson2.data.model

import com.example.m5lesson2.data.retrofit.ApiService
import retrofit2.Call
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepository @Inject constructor(private val apiService: ApiService) {
    fun getCharacters(): CharacterResponse {
        return apiService.getCharacters(0)
    }
}



