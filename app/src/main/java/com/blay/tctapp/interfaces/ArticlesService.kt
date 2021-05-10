package com.blay.tctapp.interfaces

import com.blay.tctapp.bean.ArticlesResponse
import retrofit2.http.GET

interface ArticlesService {
    @GET("response.json")
    suspend  fun getArticles(): ArticlesResponse
}