package com.anshul.theroadrunner.entities

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Attraction(
    val description: String = "",
    val facts: List<String> = listOf(),
    val id: String = "",
    val imageUrls: List<String> = listOf(),
    val location: Location = Location(),
    val monthsToVisit: String = "",
    val title: String = ""
) {
    data class Location(
        val latitude: String = "",
        val longitude: String = ""
    )
}


data class AttractionsResponse(
    val attractions: List<Attraction> = listOf()
)
