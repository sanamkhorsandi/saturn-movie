package com.saturn.movie.features.search.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.saturn.movie.databinding.MovieItemBinding
import com.saturn.movie.features.core.util.ext.fade
import com.saturn.movie.features.core.util.ext.hide
import com.saturn.movie.features.core.util.ext.show
import com.saturn.movie.features.search.domain.model.Data
import com.saturn.movie.features.search.domain.model.Size
import com.saturn.movie.features.search.domain.util.comparator.MovieComparator
import com.saturn.movie.features.search.domain.util.ext.getPoster
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class MovieAdapter @Inject constructor(private val request: RequestManager) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private val diffCallback = MovieComparator()
    private val differ = AsyncListDiffer(this, diffCallback)

    var interaction: Interaction? = null

    fun submitList(list: List<Data>) {
        differ.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size

    inner class ViewHolder(
        private val binding: MovieItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Data) = with(binding) {
            request.load(movie.getPoster(Size.L)).fade().into(poster)
            movie.movieTitle?.let { title ->
                titleFa.show()
                titleFa.text = title
            } ?: titleFa.hide()

            movie.movieTitleEn?.let { title ->
                titleEn.show()
                titleEn.text = title
            } ?: titleEn.hide()

            root.setOnClickListener {
                interaction?.onMovieClicked(movie)
            }
        }
    }

    interface Interaction {
        fun onMovieClicked(movie: Data)
    }

}