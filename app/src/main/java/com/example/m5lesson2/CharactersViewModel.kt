package com.example.m5lesson2

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.m5lesson2.data.CharacterPagingSource
import com.example.m5lesson2.data.model.Characters
import com.example.m5lesson2.data.retrofit.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val api: ApiService)
    : ViewModel() {

        fun getCharacters(): LiveData<PagingData<Characters>> {
             val pager = Pager(
                config = PagingConfig(
                    pageSize = 20,
                    prefetchDistance = 15,
                    enablePlaceholders = false
                ),
                 pagingSourceFactory = {
                     CharacterPagingSource(api)
                 }
             )
            return pager.liveData
        }

}