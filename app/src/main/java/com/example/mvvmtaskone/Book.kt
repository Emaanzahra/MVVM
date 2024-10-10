package com.example.mvvmtaskone

data class Book(
    val id : String,
    val title : String,
    val author : String,
    val yearpublished : Int
){
    fun isBookOld(): Boolean{
        return yearpublished < 2000
    }
}

