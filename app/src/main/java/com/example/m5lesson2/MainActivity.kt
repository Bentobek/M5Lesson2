package com.example.m5lesson2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m5lesson2.databinding.ActivityMainBinding
import com.example.m5lesson2.model.CharacterViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var adapter: CharacterAdapter
    private val characterList = mutableListOf<com.example.m5lesson2.model.Character>()
    private val viewModel by lazy { ViewModelProvider(this).get(CharacterViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.rvRickAndMorty.layoutManager = LinearLayoutManager(this)
        adapter = CharacterAdapter(characterList)
        binding.rvRickAndMorty.adapter = adapter

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.characters.observe(this) { characters ->
            adapter.updateList(characters)
        }
    }

}
