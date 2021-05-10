package com.blay.tctapp.helpers

import com.blay.tctapp.BuildConfig
import com.blay.tctapp.interfaces.ArticlesService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.TCT_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val service: ArticlesService = getRetrofit().create(ArticlesService::class.java)
}