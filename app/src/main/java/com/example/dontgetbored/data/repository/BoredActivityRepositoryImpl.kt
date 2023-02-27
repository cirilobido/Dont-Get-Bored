package com.example.dontgetbored.data.repository

import com.example.dontgetbored.data.dto.toBoredActivity
import com.example.dontgetbored.data.remote.BoredApi
import com.example.dontgetbored.domain.model.BoredActivityModel
import com.example.dontgetbored.domain.repository.BoredActivityRepository
import com.example.dontgetbored.util.Resource
import javax.inject.Inject

class BoredActivityRepositoryImpl @Inject constructor(private val api: BoredApi):
    BoredActivityRepository {
    override suspend fun getRandomActivity(): Resource<BoredActivityModel> {
        return try {
            Resource.Success(
                data = api.getRandomActivity().toBoredActivity()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}