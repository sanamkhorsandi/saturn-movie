package com.saturn.movie.features.search.domain.usecase

import com.saturn.movie.features.core.data.remote.NetworkConstants
import com.saturn.movie.features.core.util.common.Resource
import com.saturn.movie.features.search.domain.model.Data
import com.saturn.movie.features.search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.flow
import java.lang.NullPointerException

class Search(
    private val searchRepository: SearchRepository
) {

    operator fun invoke(query: String?) = flow<Resource<List<Data>>?> {
        try {
            if (query == null) throw NullPointerException("برای جستجو عبارتی را وارد کنید.")
            if (query.isBlank()) {
                emit(null)
                return@flow
            }
            emit(Resource.Loading())
            val result = searchRepository.search(query)
            if (result.isSuccess) {
                val data = result.getOrNull()?.data?.filterNotNull() ?: listOf()
                emit(Resource.Success(data))
            } else {
                emit(
                    Resource.Error(
                        result.exceptionOrNull()?.message ?: NetworkConstants.UNKNOWN_ERROR
                    )
                )
            }
        } catch (e: Throwable) {
            emit(Resource.Error(e.message ?: NetworkConstants.UNKNOWN_ERROR))
        }
    }
}