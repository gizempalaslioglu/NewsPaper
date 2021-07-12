package com.project.wellbeescaseproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.project.wellbeescaseproject.entity.NewsAnswers
import com.project.wellbeescaseproject.entity.NewsDetailsAnswers
import com.project.wellbeescaseproject.retrofit.ApiUtils
import com.project.wellbeescaseproject.retrofit.NewsInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var kdaoi:NewsInterface
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        kdaoi=ApiUtils.getNewsInterface()

        showNewsDetails("bbc-news")

    }

    fun showNewsDetails(news:String){
        kdaoi.getNewsBySource(news).enqueue(object :Callback<NewsDetailsAnswers>{
            override fun onResponse(
                call: Call<NewsDetailsAnswers>?,
                response: Response<NewsDetailsAnswers>
            ) {
                val detailsList=response.body().articles

                for(k in detailsList){
                    Log.e("*******","*******")
                    Log.e("news title",k.title)
                }

            }

            override fun onFailure(call: Call<NewsDetailsAnswers>?, t: Throwable?) {
                Log.e("Fail-Details",t?.message.toString())

            }
        })
    }
}