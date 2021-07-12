package com.project.wellbeescaseproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.*
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.project.wellbeescaseproject.R
import com.project.wellbeescaseproject.adapter.NewsAdapter
import com.project.wellbeescaseproject.databinding.FragmentHomepageBinding
import com.project.wellbeescaseproject.viewmodel.HomepageFragmentViewModel

//this fragment for listing news
class HomepageFragment : Fragment() {

     private lateinit var binding:FragmentHomepageBinding //data binding
     private lateinit var adapter: NewsAdapter
     private lateinit var viewModel:HomepageFragmentViewModel
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_homepage, container, false)
        binding.homepageFragment=this //yetki verdik

         viewModel.newsList.observe(viewLifecycleOwner,{newsList->
             adapter= NewsAdapter(requireContext(),newsList,viewModel)
             binding.adapter=adapter
         })

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val temp:HomepageFragmentViewModel by viewModels()
        viewModel=temp
    }


}