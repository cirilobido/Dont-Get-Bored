package com.example.dontgetbored.data.repository

import com.example.dontgetbored.data.dto.toBoredActivity
import com.example.dontgetbored.data.remote.BoredApi
import com.example.dontgetbored.domain.model.BoredActivityModel
import com.example.dontgetbored.domain.repository.BoredActivityRepository
import javax.inject.Inject

class BoredActivityRepositoryImpl @Inject constructor(private val api: BoredApi):
    BoredActivityRepository {
    override suspend fun getRandomActivity(): BoredActivityModel {
        return api.getRandomActivity().toBoredActivity()
    }
}