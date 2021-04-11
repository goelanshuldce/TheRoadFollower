package com.anshul.theroadrunner.app

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.anshul.theroadrunner.entities.Attraction

abstract class BaseFragment : Fragment() {
    protected val navController: NavController by lazy {
        (activity as MainActivity).navController
    }

    protected val attractions: List<Attraction>
        get() = (activity as MainActivity).attractionsList
}