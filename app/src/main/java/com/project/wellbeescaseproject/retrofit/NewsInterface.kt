package com.project.wellbeescaseproject.retrofit

import com.project.wellbeescaseproject.entity.NewsAnswers
import com.project.wellbeescaseproject.entity.NewsDetailsAnswers
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsInterface {
    @GET("/v2/top-headlines/sources?apiKey=79a665a5013543f2a9e6f37a863bf653")
    fun getNews() : Call<NewsAnswers>
    @GET("/v2/top-headlines/?apiKey=79a665a5013543f2a9e6f37a863bf653")
    fun getNewsBySource(@Query("sources") source:String ) : Call<NewsDetailsAnswers>
}
