package com.example.dontgetbored.data.remote

import com.example.dontgetbored.data.dto.BoredActivityDto
import retrofit2.http.GET

interface BoredApi {
    @GET("activity/")
    suspend fun getRandomActivity(): BoredActivityDto
}