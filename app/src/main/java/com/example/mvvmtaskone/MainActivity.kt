package com.example.mvvmtaskone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {



    private val bookDetail : TextView
        get() = findViewById(R.id.bookDetail)

    private val bookStatus : TextView
        get() = findViewById(R.id.bookStatus)

    private val updateButton : Button
        get() = findViewById(R.id.button)

    private val bookViewModel: BookViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bookViewModel.book.observe(this,{
            bookDetail.text = "Title: ${it.title}\nAuthor: ${it.author}\nPublished: ${it.yearpublished}"
        })

        bookViewModel.isBookOld.observe(this,{
            bookStatus.text = if (it == true){
                "The Book is Old"
            } else{
                "Book is New"
            }
        })

        updateButton.setOnClickListener {
            bookViewModel.isBookOldChecked()
        }
    }
}