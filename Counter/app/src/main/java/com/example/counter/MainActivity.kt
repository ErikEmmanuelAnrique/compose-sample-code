package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var counterText: TextView
    lateinit var counterButton: Button
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        counterText = findViewById(R.id.counterText)
        counterText.text = count.toString()
        counterButton = findViewById(R.id.counterButton)
        counterButton.setOnClickListener {
            count++
            counterText.text = count.toString()
        }
    }
}