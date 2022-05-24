package com.example.jokeprojectbeforemiddleexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvInit = findViewById<TextView>(R.id.tvGoJokes)

        tvInit.setOnClickListener {

            val intent = Intent(this, JokeActivity::class.java).apply {
            }

            startActivity(intent)
        }

    }
}