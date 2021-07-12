package com.project.wellbeescaseproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

//class representing array and message
data class NewsAnswers (@SerializedName("sources")
                        @Expose
                        var sources:List<News>
                        ,
                        @SerializedName("status")
                        @Expose
                        var status:String) {
}
