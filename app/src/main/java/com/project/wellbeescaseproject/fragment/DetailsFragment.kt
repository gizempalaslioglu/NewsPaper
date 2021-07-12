package com.project.wellbeescaseproject.fragment

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.project.wellbeescaseproject.R
import com.project.wellbeescaseproject.adapter.NewsAdapter
import com.project.wellbeescaseproject.adapter.NewsDetailAdapter
import com.project.wellbeescaseproject.databinding.FragmentDetailsBinding
import com.project.wellbeescaseproject.entity.NewsDetails
import com.project.wellbeescaseproject.viewmodel.DetailsFragmentViewModel
//this fragment for listing news details
class DetailsFragment : Fragment() {
    private lateinit var binding : FragmentDetailsBinding
    val b: DetailsFragmentArgs by navArgs()
    private val tempViewModel: DetailsFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Log.v("Tag",b.sourceName)

        tempViewModel.breakingNews(b.sourceName) //argument
        tempViewModel.newDetailList.observe(viewLifecycleOwner, Observer<List<NewsDetails>>{
            val adapter = NewsDetailAdapter(requireContext())
            adapter.addNews(ArrayList(it))
            binding.newsRecycler.adapter = adapter
        })

    }

}