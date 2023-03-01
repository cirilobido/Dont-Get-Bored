package com.example.dontgetbored.presentation.homescreen

import com.example.dontgetbored.domain.model.BoredActivityModel

data class HomeState(
    val boredActivity: BoredActivityModel? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)