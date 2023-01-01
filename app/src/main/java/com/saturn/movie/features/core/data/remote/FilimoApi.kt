package com.saturn.movie.features.core.data.remote

import com.saturn.movie.features.core.data.remote.Endpoints.SEARCH_MOVIES
import com.saturn.movie.features.search.data.remote.dto.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface FilimoApi {

    @GET(SEARCH_MOVIES)
    suspend fun search(@Path("query") query: String): SearchResponse

}