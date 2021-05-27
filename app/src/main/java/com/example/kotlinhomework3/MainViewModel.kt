package com.example.kotlinhomework3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {


    private val _count = MutableLiveData<Int>()
    private val _historyminus = MutableLiveData<String>()
    private val _historyplus = MutableLiveData<String>()
    private var counter = 0

    val count: LiveData<Int>
        get() = _count

    val mHistoryminus: LiveData<String>
        get() = _historyminus

    val mHistoryplus: LiveData<String>
        get() = _historyplus

    fun incrementCount() {
        _count.value = ++counter
        _historyplus.value = _historyplus.value+ increment
    }

    fun decrementCount() {
        _count.value = --counter
        _historyminus.value = _historyminus.value+ decrement
    }

    init {
        _count.postValue(0)
        _historyplus.postValue("")
        _historyminus.postValue("")
    }
    companion object{
        const val increment = "➕"
        const val decrement = "➖"
    }
}