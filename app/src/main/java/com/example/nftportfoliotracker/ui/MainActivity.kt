package com.example.nftportfoliotracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nftportfoliotracker.R
import com.example.nftportfoliotracker.util.Resource
import com.example.nftportfoliotracker.util.Status
import com.example.nftportfoliotracker.viewmodel.MainViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.getMainResponse("0x263462e25018c092ac747237f6d81ee761de7643", "ethereum").observe(this,{
            when(it.status){
                Status.SUCCESS -> {
                    it.message?.toString()?.let { it1 -> Log.d("MainViewModelModel", it1) }
                }
            }

        })

    }
}