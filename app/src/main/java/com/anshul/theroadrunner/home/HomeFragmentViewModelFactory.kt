package com.anshul.theroadrunner.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anshul.theroadrunner.entities.Attraction


class HomeFragmentViewModelFactory(
    private val application: Application, private val attractions: List<Attraction>
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeFragmentViewModel::class.java)) {
            return HomeFragmentViewModel(application, attractions) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}