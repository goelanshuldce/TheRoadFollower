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

    private val _navigateToSelectedAttraction = MutableLiveData<String>()
    val navigateToSelectedAttraction: LiveData<String> get() = _navigateToSelectedAttraction

    init {
        viewModelScope.launch {
            _attractions.value = rawDataRepository.fetchAttractionsData()
        }
    }

    /**
     * When the property is clicked, set the [_navigateToSelectedAttraction] [MutableLiveData]
     * @param attractionId The [Attraction] that was clicked on.
     */
    fun displayAttractionDetails(attractionId: String) {
        _navigateToSelectedAttraction.value = attractionId
    }

    /**
     * After the navigation has taken place, make sure navigateToSelectedProperty is set to null
     */
    fun displayAttractionDetailsComplete() {
        _navigateToSelectedAttraction.value = null
    }

}