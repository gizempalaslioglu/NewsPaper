package com.project.wellbeescaseproject.retrofit

class ApiUtils {

    companion object{

        val BASE_URL = "https://newsapi.org"

        fun getNewsInterface(): NewsInterface {
            return RetrofitClient.getClient(BASE_URL).create(NewsInterface::class.java)
        }
    }
}



