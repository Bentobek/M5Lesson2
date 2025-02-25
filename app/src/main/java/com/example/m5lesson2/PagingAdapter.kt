package com.example.m5lesson2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.m5lesson2.data.model.Characters
import com.example.m5lesson2.databinding.ItemSeriesBinding

class PagingAdapter : PagingDataAdapter<Characters, PagingAdapter.CharacterViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Characters>() {
            override fun areItemsTheSame(oldItem: Characters, newItem: Characters): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Characters, newItem: Characters): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemSeriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        character?.let { holder.bind(it) }
    }

    class CharacterViewHolder(private val binding: ItemSeriesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Characters) {
            binding.tvName.text = character.name
            binding.tvSpecies.text = character.species
            binding.tvStatus.text = "Status: ${character.status}"
        }
    }
}