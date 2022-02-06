package com.example.nftportfoliotracker.api

import com.example.nftportfoliotracker.model.MainResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {


    @GET("v0/accounts/{address}?include=metadata")
    fun getHomeFeed(@Path(value = "address", encoded = true) address:String,
                    @Query("chain") platform : String
                    ): Call<MainResponse>

}
