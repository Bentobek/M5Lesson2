package com.example.m5lesson2.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.m5lesson2.data.model.Characters
import com.example.m5lesson2.data.retrofit.ApiService
import javax.inject.Inject

const val START_INDEX = 1

class CharacterPagingSource @Inject constructor(
    private val apiService: ApiService
): PagingSource<Int, Characters>() {

    override fun getRefreshKey(state: PagingState<Int, Characters>): Int? {
        return state.anchorPosition?.let {anchorPosition->
            val closestPageToPosition = state.closestPageToPosition(anchorPosition)
            closestPageToPosition?.prevKey?.plus(1) ?: closestPageToPosition?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Characters> {
        return try {
            val currentPage = params.key ?: START_INDEX
            val response = apiService.getCharacters(currentPage)

            LoadResult.Page(
                data = response.results,
                prevKey = if (currentPage == START_INDEX) null else currentPage - 1,
                nextKey = if (response.info.next.isNullOrEmpty()) null else currentPage + 1
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}