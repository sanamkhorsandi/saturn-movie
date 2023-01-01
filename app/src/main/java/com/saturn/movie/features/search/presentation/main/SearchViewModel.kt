package com.saturn.movie.features.search.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saturn.movie.features.search.domain.usecase.Search
import com.saturn.movie.features.theme.domain.repository.ThemeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val search: Search,
    private val themeRepository: ThemeRepository
) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state: StateFlow<SearchState> = _state.asStateFlow()

    private val _theme = MutableStateFlow(themeRepository.getTheme())
    val theme = _theme.asStateFlow()

    init {

    }

    fun onEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.OnQueryChanged -> {
                if (state.value.query != event.value) {
                    _state.value = state.value.copy(query = event.value)
                    doSearch(event.value)
                }
            }
            is SearchEvent.SetTheme -> {
                themeRepository.setTheme(event.theme)
                _theme.value = event.theme
            }
        }
    }

    private fun doSearch(query: String?) {
        search(query).onEach { resource ->
            _state.value = state.value.copy(movies = resource)
        }.launchIn(viewModelScope)
    }
}