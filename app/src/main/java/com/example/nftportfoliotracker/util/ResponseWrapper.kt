package com.example.nftportfoliotracker.util

import com.google.gson.annotations.SerializedName

class ResponseWrapper<T>{

    @SerializedName("status")
    var status : Boolean? = null

    @SerializedName("code")
    var code : Int? = null

    @SerializedName("data")
    var data : T? = null

    @SerializedName("message")
    var message : String? = null
}