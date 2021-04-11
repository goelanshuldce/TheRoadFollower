package com.anshul.theroadrunner.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Attraction(
    val description: String,
    val facts: List<String> = listOf(),
    val id: String,

    @Json(name = "image_urls")
    val imageUrls: List<String>,
    val location: Location = Location(),

    @Json(name = "months_to_visit")
    val monthsToVisit: String,
    val title: String
) {
    data class Location(
        val latitude: String = "",
        val longitude: String = ""
    )
}


data class AttractionsResponse(
    val attractions: List<Attraction>
)
