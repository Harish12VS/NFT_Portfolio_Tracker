package com.example.nftportfoliotracker.api

import android.content.Context
import com.example.nftportfoliotracker.BuildConfig
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient(val context: Context) {

    companion object{
        val RESPONSE_200 = 200

        val RESPONSE_400 = 400

        val RESPONSE_401 = 401

        val RESPONSE_404 = 404

        val RESPONSE_500 = 500
    }

    private var retrofit: Retrofit? = null

    private fun getOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if(BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }else{
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original: Request = chain.request()
                // Request customization: add request headers
                val requestBuilder: Request.Builder = original.newBuilder()
                    .header("Authorization","${BuildConfig.API_KEY}")
                    .header("Content-Type","application/json")
                    .method(original.method, original.body)
                val request: Request = requestBuilder.build()
                chain.proceed(request)
            }
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    val getV2Service: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}
