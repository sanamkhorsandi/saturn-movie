package com.saturn.movie.di

import com.saturn.movie.features.core.data.remote.FilimoApi
import com.saturn.movie.features.search.data.repository.SearchRepositoryImpl
import com.saturn.movie.features.search.domain.repository.SearchRepository
import com.saturn.movie.features.search.domain.usecase.Search
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SearchModule {

    @Provides
    @Singleton
    fun provideSearchRepository(api: FilimoApi): SearchRepository {
        return SearchRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideSearchUseCase(repository: SearchRepository): Search {
        return Search(repository)
    }
}