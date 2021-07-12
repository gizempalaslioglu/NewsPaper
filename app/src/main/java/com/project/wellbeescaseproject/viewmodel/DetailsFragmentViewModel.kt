package com.project.wellbeescaseproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.wellbeescaseproject.entity.NewsDetails
import com.project.wellbeescaseproject.repo.NewsRepository

class DetailsFragmentViewModel:ViewModel() {
    var newDetailList = MutableLiveData<List<NewsDetails>>()
    val kdaor = NewsRepository()

    fun breakingNews(sourceName:String){
        kdaor.fetchNewsBySource(sourceName)
        newDetailList = kdaor.getNewsBySource()
    }



}