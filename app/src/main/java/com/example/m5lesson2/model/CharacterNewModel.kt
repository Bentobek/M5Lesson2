package com.example.m5lesson2.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.m5lesson2.retrofit.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterNewModel @Inject constructor(private val apiService: ApiService) {
    fun getCharacters(): Call<CharacterResponse> {
        return apiService.getCharacters()
    }
}