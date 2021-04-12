package com.anshul.theroadrunner.data

import android.content.Context
import com.anshul.theroadrunner.R
import com.anshul.theroadrunner.entities.Attraction
import com.anshul.theroadrunner.entities.AttractionsResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


object RawDataManager {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun getAttractionsJson(context: Context): List<Attraction> {
        return parseAttractions(context)
    }

    private fun parseAttractions(context: Context): List<Attraction> {
        val textFromFile =
            context.resources.openRawResource(R.raw.croatia).bufferedReader().use { it.readText() }
        val adapter: JsonAdapter<AttractionsResponse> =
            moshi.adapter(AttractionsResponse::class.java)
        return adapter.fromJson(textFromFile)?.attractions ?: emptyList()
    }
}