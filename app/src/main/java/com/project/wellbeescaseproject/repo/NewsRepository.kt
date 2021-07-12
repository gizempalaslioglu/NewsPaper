package com.project.wellbeescaseproject.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.project.wellbeescaseproject.entity.News
import com.project.wellbeescaseproject.entity.NewsAnswers
import com.project.wellbeescaseproject.entity.NewsDetails
import com.project.wellbeescaseproject.entity.NewsDetailsAnswers
import com.project.wellbeescaseproject.retrofit.ApiUtils
import com.project.wellbeescaseproject.retrofit.NewsInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    private val newsList:MutableLiveData<List<News>>
    private val news=MutableLiveData<List<NewsDetails>>()
    private val kdaoi:NewsInterface

    init {

        kdaoi=ApiUtils.getNewsInterface()
        newsList= MutableLiveData()
    }

    fun getNews():MutableLiveData<List<News>>{ //We transfer the information from the database to the newsList
        return newsList
    }
    fun getNewsBySource():MutableLiveData<List<NewsDetails>>{
        return news
    }
    fun showNews(){
        kdaoi.getNews().enqueue(object : Callback<NewsAnswers> {
            override fun onResponse(call: Call<NewsAnswers>?, response: Response<NewsAnswers>) {
                val list=response.body().sources  //for sources
                newsList.value=list

            }

            override fun onFailure(call: Call<NewsAnswers>?, t: Throwable?) {
                Log.e("Fail",t?.message.toString())
            }
        })

    }
    fun fetchNewsBySource(sourceName:String){
        kdaoi.getNewsBySource(sourceName).enqueue(object :Callback<NewsDetailsAnswers>{
            override fun onResponse(
                call: Call<NewsDetailsAnswers>?,
                response: Response<NewsDetailsAnswers>
            ) {
                news.value = response.body().articles
            }

            override fun onFailure(call: Call<NewsDetailsAnswers>?, t: Throwable?) {
                Log.e("Fail",t?.message.toString())
            }

        })
    }
}