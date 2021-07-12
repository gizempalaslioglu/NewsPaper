package com.project.wellbeescaseproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsDetailsAnswers (@SerializedName("articles")
                        @Expose
                        var articles:List<NewsDetails>
                        ,
                        @SerializedName("status")
                        @Expose
                        var status:String) {
}