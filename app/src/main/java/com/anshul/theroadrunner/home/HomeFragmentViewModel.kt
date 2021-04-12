package com.anshul.theroadrunner.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.anshul.theroadrunner.entities.Attraction
import com.anshul.theroadrunner.repository.RawDataRepository
import kotlinx.coroutines.launch

class HomeFragmentViewModel(application: Application) :
    AndroidViewModel(application) {

    private val rawDataRepository = RawDataRepository(application.applicationContext)

    private val _attractions = MutableLiveData<List<Attraction>>()
    val attractions: LiveData<List<Attraction>> get() = _attractions

    private val _navigateToSelectedAttraction = MutableLiveData<Int>()
    val navigateToSelectedAttraction: LiveData<Int> get() = _navigateToSelectedAttraction

    init {
        viewModelScope.launch {
            _attractions.value = rawDataRepository.fetchAttractionsData()
        }
    }


}