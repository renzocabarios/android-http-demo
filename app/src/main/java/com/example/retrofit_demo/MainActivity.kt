package com.example.retrofit_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById(R.id.button) as Button

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

        button.setOnClickListener {
            // launching a new coroutine
            GlobalScope.launch {
                val result = quotesApi.getQuotes()
                if (result != null)
                // Checking the results
                    Log.d("ayush: ", result.body().toString())
            }
        }

    }
}