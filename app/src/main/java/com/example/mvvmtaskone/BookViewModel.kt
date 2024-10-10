package com.example.mvvmtaskone

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BookViewModel : ViewModel() {

    private val _book = MutableLiveData<Book>()
    val book : LiveData<Book>
        get() = _book

    private val _isBookOld = MutableLiveData<Boolean>()
    val isBookOld : LiveData<Boolean>
        get() = _isBookOld

    init {
        _book.value = Book("1", "The Hobbit", "J.R.R. Tolkien", 2023)
    }

    fun isBookOldChecked(){
        _isBookOld.value = _book.value?.isBookOld()
    }
}