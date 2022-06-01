package com.example.zlhhapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _message = MutableLiveData<List<String>>()

    val messages: LiveData<List<String>> = _message

    var newList = _message.value.orEmpty().toMutableList()

    fun sendMessage(text: String) {
        newList.add(text)
        _message.value = newList
    }

    fun removeMessage(text: String) {
        val newList = _message.value.orEmpty().toMutableList()
        newList.remove(text)
        _message.value = newList
    }

}

