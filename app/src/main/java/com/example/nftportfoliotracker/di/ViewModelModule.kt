package com.example.nftportfoliotracker.di


import com.example.nftportfoliotracker.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {


    //V2
    viewModel { MainViewModel(get()) }

}