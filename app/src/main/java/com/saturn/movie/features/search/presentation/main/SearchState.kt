package com.saturn.movie.features.search.presentation.main

import com.saturn.movie.features.core.util.common.Resource
import com.saturn.movie.features.search.domain.model.Data

data class SearchState(
    val movies: Resource<List<Data>>? = null,
    val query: String? = null
)
