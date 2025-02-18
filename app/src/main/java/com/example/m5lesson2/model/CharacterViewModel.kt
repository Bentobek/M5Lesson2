package com.example.m5lesson2.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class CharacterViewModel: ViewModel()  {
    private val characterModel = CharacterNewModel()
    val characters: LiveData<List<Character>> = characterModel.getCharacters()

}