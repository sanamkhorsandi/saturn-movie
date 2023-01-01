package com.saturn.movie.features.search.domain.util.comparator

import androidx.recyclerview.widget.DiffUtil
import com.saturn.movie.features.search.domain.model.Data

class MovieComparator : DiffUtil.ItemCallback<Data>() {
    override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.movieId == newItem.movieId
    }

    override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
        return oldItem.hashCode() == newItem.hashCode()
    }

    override fun getChangePayload(oldItem: Data, newItem: Data): Any {
        return newItem
    }
}