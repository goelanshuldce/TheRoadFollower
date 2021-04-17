package com.anshul.theroadrunner.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anshul.theroadrunner.databinding.FragmentAttractionDetailsBinding
import timber.log.Timber

class AttractionDetailFragment : Fragment() {

//    private var _binding: FragmentAttractionDetailsBinding? = null
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val application = requireNotNull(activity).application
        val binding = FragmentAttractionDetailsBinding.inflate(inflater, container, false)
        val attractionId = AttractionDetailFragmentArgs.fromBundle(requireArguments()).attractionId
        Timber.d("The attraction selected is: $attractionId")
        return binding.root
    }

//    override fun onDestroy() {
//        super.onDestroy()
////        _binding = null
//    }
}