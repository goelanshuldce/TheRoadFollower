package com.anshul.theroadrunner.repository

import android.content.Context
import com.anshul.theroadrunner.data.RawDataManager
import com.anshul.theroadrunner.entities.Attraction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RawDataRepository(private val context: Context) {
    suspend fun fetchAttractionsData(): List<Attraction> {
        return withContext(Dispatchers.IO) {
            return@withContext RawDataManager.getAttractionsJson(context)
        }
    }
}