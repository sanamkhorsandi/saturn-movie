package com.saturn.movie.features.theme.domain.repository

import com.saturn.movie.features.theme.domain.model.Theme

interface ThemeRepository {

    fun getTheme(): Theme

    fun setTheme(theme: Theme)
}