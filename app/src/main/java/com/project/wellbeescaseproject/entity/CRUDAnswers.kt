package com.project.wellbeescaseproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CRUDAnswers(@SerializedName("status")
                       @Expose
                       var status:String
                       ,
                       @SerializedName("message")
                       @Expose
                       var message:String) {

}