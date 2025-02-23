package com.example.m5lesson2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.m5lesson2.databinding.ActivityMainBinding
import com.example.m5lesson2.model.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CharacterViewModel
    private lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        val viewModel: CharacterViewModel by viewModels()

        adapter = CharacterAdapter(characters = emptyList())
        binding.rvRickAndMorty.layoutManager = LinearLayoutManager(this)
        binding.rvRickAndMorty.adapter = adapter

        viewModel.characters.observe(this) { characters ->
            if (characters != null) {
                adapter.updateList(characters)
            }
        }

        viewModel.fetchCharacters()
    }
}
