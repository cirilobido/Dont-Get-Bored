package com.example.dontgetbored.domain.repository

import com.example.dontgetbored.domain.model.BoredActivityModel

interface BoredActivityRepository {
    suspend fun getRandomActivity(): BoredActivityModel
}