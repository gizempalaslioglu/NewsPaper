package com.project.wellbeescaseproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.project.wellbeescaseproject.entity.News
import com.project.wellbeescaseproject.repo.NewsRepository
import java.util.ArrayList

class HomepageFragmentViewModel:ViewModel() {

    var newsList= MutableLiveData<List<News>>()
    val kdaor=NewsRepository()
    init {
        loadNews()
        newsList=kdaor.getNews() // it will bring list to the newsList with the getNews method
    }

    fun loadNews(){
        kdaor.showNews()
    }
}
