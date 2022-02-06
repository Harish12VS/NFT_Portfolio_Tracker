package com.example.nftportfoliotracker.api

import androidx.lifecycle.LiveData
import com.example.nftportfoliotracker.model.MainResponse
import com.example.nftportfoliotracker.remote.ApiResponse
import com.example.nftportfoliotracker.util.ResponseWrapper
import retrofit2.http.*

interface ApiInterface {


    @GET("v0/accounts/{address}?include=metadata")
    fun getHomeFeed(@Path(value = "address", encoded = true) address:String,
                    @Query("chain") platform : String
                    ): LiveData<ApiResponse<ResponseWrapper<MainResponse>>>

}
