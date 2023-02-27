package com.example.dontgetbored.data.dto

import com.example.dontgetbored.domain.model.BoredActivityModel

data class BoredActivityDto(
    val accessibility: Double,
    val activity: String,
    val key: String,
    val link: String,
    val participants: Int,
    val price: Double,
    val type: String,
)

fun BoredActivityDto.toBoredActivity(): BoredActivityModel{
    return BoredActivityModel(
        accessibility = this.accessibility,
        activity = this.activity,
        key = this.key,
        link = this.link,
        participants = this.participants,
        price = this.price,
        type = this.type,
    )
}