package com.anshul.theroadrunner.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.anshul.theroadrunner.R
import com.anshul.theroadrunner.entities.Attraction
import com.anshul.theroadrunner.entities.AttractionsResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    val attractionsList: List<Attraction> by lazy {
        parseAttractions()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    // TODO:  This should be at data layer and not here
    private fun parseAttractions(): List<Attraction> {
        val textFromFile =
            resources.openRawResource(R.raw.croatia).bufferedReader().use { it.readText() }
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter: JsonAdapter<AttractionsResponse> =
            moshi.adapter(AttractionsResponse::class.java)
        return adapter.fromJson(textFromFile)?.attractions ?: emptyList()
    }
}