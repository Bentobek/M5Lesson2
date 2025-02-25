package com.example.m5lesson2.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _characters = MutableLiveData<List<Characters>>()
    val characters: LiveData<List<Characters>> get() = _characters

//    fun fetchCharacters() {
//        repository.getCharacters().enqueue(object : Callback<CharacterResponse> {
//            override fun onResponse(call: Call<CharacterResponse>, response: Response<CharacterResponse>) {
//                if (response.isSuccessful) {
//                    _characters.postValue(response.body()?.results)
//                } else {
//                    Log.e("API_ERROR", "Ошибка ответа сервера: ${response.code()}")
//                }
//            }
//
//            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
//                Log.e("API_ERROR", "Ошибка сети: ${t.message}")
//            }
//        })
//    }
}

