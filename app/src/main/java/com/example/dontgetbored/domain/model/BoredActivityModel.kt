package com.example.dontgetbored.domain.model

data class BoredActivityModel(
    val accessibility: Double,
    val activity: String,
    val key: String,
    val link: String,
    val participants: Int,
    val price: Double,
    val type: String,
)
