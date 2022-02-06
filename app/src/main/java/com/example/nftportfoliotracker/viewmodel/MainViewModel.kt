package com.example.nftportfoliotracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.nftportfoliotracker.model.MainResponse
import com.example.nftportfoliotracker.repo.MainRepository
import com.example.nftportfoliotracker.util.Resource


class MainViewModel(private val homeRepository: MainRepository) : ViewModel() {
    fun getMainResponse(address: String, chain:String): LiveData<Resource<MainResponse>> = homeRepository.loadMain(address,chain)

}