package com.saturn.movie.features.theme.data.repository

import com.saturn.movie.features.theme.data.pref.ThemePreferences
import com.saturn.movie.features.theme.domain.model.Theme
import com.saturn.movie.features.theme.domain.repository.ThemeRepository

class ThemeRepositoryImpl(
    private val preferences: ThemePreferences
) : ThemeRepository {
    override fun getTheme(): Theme {
        return Theme.fromValue(preferences.getTheme())
    }

    override fun setTheme(theme: Theme) {
        preferences.setTheme(theme)
    }
}