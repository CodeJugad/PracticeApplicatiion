package com.example.practiceapplicatiion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _text = MutableLiveData("Hello, Data Binding!")
    val text: LiveData<String> = _text

    fun onButtonClick() {
        _text.value = "Text Changed!"
    }
}
