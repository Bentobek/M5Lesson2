package com.example.m5lesson2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m5lesson2.databinding.ItemSeriesBinding
import com.example.m5lesson2.data.model.Characters

class CharacterAdapter(private var characters: List<Characters>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemSeriesBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(character: Characters) {
            binding.tvName.text = character.name
            binding.tvSpecies.text = character.species
            binding.tvStatus.text = "Status: ${character.status}"

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newCharacters: List<Characters>) {
        characters = newCharacters
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters[position])
    }

    override fun getItemCount(): Int = characters.size
}
