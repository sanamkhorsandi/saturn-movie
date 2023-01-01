package com.saturn.movie.features.search.data.remote.dto.response


import androidx.annotation.Keep
import com.saturn.movie.features.search.domain.model.Data
import com.saturn.movie.features.search.domain.model.Meta
import com.google.gson.annotations.SerializedName

@Keep
data class SearchResponse(
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("meta")
    val meta: Meta?
)