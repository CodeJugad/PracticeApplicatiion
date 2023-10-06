package com.example.practiceapplicatiion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MyViewModel(private val apiService: ApiService) : ViewModel() {
    val postLiveData = MutableLiveData<Post>()

    fun fetchPost() {
        viewModelScope.launch {
            try {
                val response = apiService.getPost()
                postLiveData.postValue(response)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}

