package com.example.batmanfilms.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.batmanfilms.models.SearchItem

class BatmanFilmsDiffUtilCallback : DiffUtil.ItemCallback<SearchItem>()  {
    override fun areItemsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
        return oldItem.imdbID == newItem.imdbID
    }

    override fun areContentsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
        return oldItem.imdbID == newItem.imdbID
    }
}