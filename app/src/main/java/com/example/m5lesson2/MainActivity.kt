package com.example.m5lesson2

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m5lesson2.data.model.CharacterViewModel
import com.example.m5lesson2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CharacterViewModel
    private lateinit var adapter: CharacterAdapter
    private lateinit var characterAdapter: PagingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        val viewModel: CharacterViewModel by viewModels()
        val charactersViewModel: CharactersViewModel by viewModels()

        characterAdapter = PagingAdapter()
        binding.rvRickAndMorty.layoutManager = LinearLayoutManager(this)
        binding.rvRickAndMorty.adapter = characterAdapter


        charactersViewModel.getCharacters().observe(this) { pagingData ->
            characterAdapter.submitData(lifecycle, pagingData)
        }
    }
}
