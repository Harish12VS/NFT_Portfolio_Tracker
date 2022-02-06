package com.example.nftportfoliotracker.repo

import androidx.lifecycle.LiveData
import com.example.nftportfoliotracker.api.ApiClient
import com.example.nftportfoliotracker.db.AppDatabaseProvider
import com.example.nftportfoliotracker.model.MainResponse
import com.example.nftportfoliotracker.remote.NetworkBoundResource
import com.example.nftportfoliotracker.util.Resource
import com.example.nftportfoliotracker.util.ResponseWrapper


class MainRepository(
    private val appDatabase: AppDatabaseProvider,
    private val apiClient: ApiClient
) {

    fun loadMain(address:String, chain:String): LiveData<Resource<MainResponse>> {
        return object : NetworkBoundResource<MainResponse, MainResponse>() {
            override fun saveCallResult(item: ResponseWrapper<MainResponse>) {
                item.data?.let {
                    appDatabase.getMainModelDao().deleteAll()
                    appDatabase.getMainModelDao().insert(it)
                }
            }

            override fun shouldFetch(data: MainResponse?): Boolean {
                return true
            }

            override fun loadFromDb() = appDatabase.getMainModelDao().getAll()

            override fun createCall() = apiClient.getV2Service.getHomeFeed(address,chain)

            override fun onFetchFailed() {
                appDatabase.getMainModelDao().getAll()
            }
        }.asLiveData()
    }
}