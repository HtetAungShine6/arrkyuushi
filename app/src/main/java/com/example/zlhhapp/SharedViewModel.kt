package com.example.zlhhapp

import androidx.compose.ui.platform.textInputServiceFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.android.synthetic.main.fragment_2.*

class SharedViewModel : ViewModel() {

    val _message  = MutableLiveData<List<String>>()
    val messages: LiveData<List<String>> = _message

    var newList = _message.value.orEmpty().toMutableList()

    fun sendMessage(text : String) {
        newList.add(text)
        _message.value = newList
    }

    fun removeMessage(text: String) {
        newList.remove(text)
    }

}

private fun <T> MutableLiveData<T>.removeObserver() {

}








