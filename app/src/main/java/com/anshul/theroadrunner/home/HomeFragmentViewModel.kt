package com.anshul.theroadrunner.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.anshul.theroadrunner.entities.Attraction
import kotlinx.coroutines.launch

class HomeFragmentViewModel(application: Application, attractions: List<Attraction>) :
    AndroidViewModel(application) {

    lateinit var attractions: List<Attraction>

    init {
        viewModelScope.launch {
            this@HomeFragmentViewModel.attractions = attractions
        }
    }
}