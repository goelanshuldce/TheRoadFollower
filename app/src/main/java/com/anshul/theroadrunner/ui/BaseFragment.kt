package com.anshul.theroadrunner.ui

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.anshul.theroadrunner.MainActivity

abstract class BaseFragment : Fragment() {
    protected val navController: NavController by lazy {
        (activity as MainActivity).navController
    }
}