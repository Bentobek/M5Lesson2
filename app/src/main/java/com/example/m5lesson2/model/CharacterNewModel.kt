package com.example.m5lesson2.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.m5lesson2.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterNewModel {
    private val apiService = RetrofitInstance.api

    fun getCharacters(): LiveData<List<Character>> {
        val data = MutableLiveData<List<Character>>()

        apiService.getCharacters().enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
                if (response.isSuccessful) {
                    data.value = response.body()?.results as List<Character>
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("API_ERROR", "Ошибка: ${t.message}")
            }
        })

        return data
    }
}