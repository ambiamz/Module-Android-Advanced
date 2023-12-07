package com.example.module

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExampleViewModel : ViewModel() {

    private val _dataList = MutableLiveData<List<String>>()
    val dataList: LiveData<List<String>> get() = _dataList

    init {
        loadData()
    }

    private fun loadData() {

        val data = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")
        _dataList.value = data
    }


}
