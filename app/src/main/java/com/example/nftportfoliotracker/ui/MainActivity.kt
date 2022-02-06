package com.example.nftportfoliotracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nftportfoliotracker.R
import com.example.nftportfoliotracker.adapter.NFTAdapter
import com.example.nftportfoliotracker.api.ApiClient
import com.example.nftportfoliotracker.model.MainResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val apiClient: ApiClient by inject()
    private var adapter: NFTAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRv()
        getNFTOfAddress()


        material_button?.setOnClickListener {
            if(et_nft?.text?.toString()?.isNullOrEmpty() == true){
                Toast.makeText(this, "Enter ethereum address", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            getNFTOfAddress()
        }

    }

    private fun initRv() {
        adapter = NFTAdapter(emptyList())
        rv_nft_list.adapter = adapter
        rv_nft_list.layoutManager = LinearLayoutManager(this)
    }

    private fun getNFTOfAddress() {
        apiClient.getV2Service.getHomeFeed(et_nft?.text?.toString()?:"","ethereum").enqueue(object:
            Callback<MainResponse> {
            override fun onResponse(call: Call<MainResponse>, response: Response<MainResponse>) {
                response.body()?.nfts?.get(0)?.let { Log.d("BroBruh", it?.description) }
                response.body()?.nfts?.let { adapter?.setNftList(it) }
            }

            override fun onFailure(call: Call<MainResponse>, t: Throwable) {

            }

        })
    }
}