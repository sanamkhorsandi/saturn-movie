package com.saturn.movie.features.search.presentation.main

import com.saturn.movie.features.theme.domain.model.Theme

sealed class SearchEvent {
    data class OnQueryChanged(val value: String?) : SearchEvent()
    data class SetTheme(val theme: Theme) : SearchEvent()
}
