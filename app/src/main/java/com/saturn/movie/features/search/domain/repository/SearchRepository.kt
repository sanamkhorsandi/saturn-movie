package com.saturn.movie.features.search.domain.repository

import com.saturn.movie.features.search.data.remote.dto.response.SearchResponse

interface SearchRepository {

    suspend fun search(query: String): Result<SearchResponse>
}