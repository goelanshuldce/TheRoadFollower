package com.anshul.theroadrunner.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.anshul.theroadrunner.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var viewModel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val application = requireNotNull(activity).application
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val viewModelFactory = HomeFragmentViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.recyclerview.adapter =
            HomeFragmentAdapter(HomeFragmentAdapter.OnClickListener { attractionId ->
                viewModel.displayAttractionDetails(attractionId)
            })
        viewModel.navigateToSelectedAttraction.observe(
            viewLifecycleOwner,
            { attractionId ->
                attractionId?.let {
                    this.findNavController().navigate(
                        HomeFragmentDirections.actionHomeFragmentToAttractionDetailFragment(it)
                    )
                }
            })
        return binding.root
    }
}

