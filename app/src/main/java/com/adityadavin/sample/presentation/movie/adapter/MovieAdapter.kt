package com.adityadavin.sample.presentation.movie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.adityadavin.sample.databinding.ItemMovieBinding
import com.adityadavin.sample.domain.movie.model.Movie
import com.adityadavin.sample.presentation.movie.adapter.MovieAdapter.MovieViewHolder
import com.adityadavin.sunshine.utils.ext.onClick
import com.adityadavin.sunshine.utils.ext.setImageUrl
import com.adityadavin.sunshine.utils.recyclerview.adapter.BaseRecyclerViewAdapter
import com.adityadavin.sunshine.utils.recyclerview.adapter.BaseRecyclerViewHolder

class MovieAdapter(private val context: Context, list: MutableList<Movie>, private val onItemClicked: ((Movie) -> Unit)?) :
    BaseRecyclerViewAdapter<Movie, MovieViewHolder>(context, list) {

    override fun getViewBinding(parent: ViewGroup?, viewType: Int): ViewBinding =
        ItemMovieBinding.inflate(LayoutInflater.from(parent?.context), parent, false)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(context, getViewBinding(parent, viewType))

    inner class MovieViewHolder(context: Context, private val binding: ViewBinding) : BaseRecyclerViewHolder<Movie>(context, binding) {

        override fun bind(data: Movie) {
            with(binding as ItemMovieBinding) {
                data.posterPath?.let { imgPoster.setImageUrl(context, it) }
                tvTitle.text = data.title
                root.onClick {
                    onItemClicked?.invoke(data)
                }
            }
        }
    }
}