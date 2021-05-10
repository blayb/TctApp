package com.blay.tctapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blay.tctapp.bean.ArticlesResponse
import com.blay.tctapp.helpers.RetrofitBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticlesViewModel : ViewModel() {

    fun getData() {
        viewModelScope.launch((Dispatchers.IO)) {
            try {
                val data = RetrofitBuilder.service.getArticles()
                articlesMutable.postValue(data)
            } catch (e: Exception){
                articlesMutable.postValue(null)
            }

        }

    }

    val articles: LiveData<ArticlesResponse>
        get() = articlesMutable

    private val articlesMutable: MutableLiveData<ArticlesResponse> by lazy {
        MutableLiveData<ArticlesResponse>()
    }
}