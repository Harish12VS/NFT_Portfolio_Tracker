package com.example.nftportfoliotracker.di


import com.example.nftportfoliotracker.api.ApiClient
import com.google.gson.Gson
import com.google.gson.JsonParser
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val appModule = module {


    single { Gson() }
    single { JsonParser() }
    single { ApiClient(androidContext()) }


}