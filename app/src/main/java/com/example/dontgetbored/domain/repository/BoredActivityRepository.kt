package com.example.dontgetbored.domain.repository

import com.example.dontgetbored.domain.model.BoredActivityModel
import com.example.dontgetbored.util.Resource

interface BoredActivityRepository {
    suspend fun getRandomActivity(): Resource<BoredActivityModel>
}