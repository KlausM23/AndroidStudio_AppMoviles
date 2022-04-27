package com.example.findevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

const val EXTRA_MESS = "com.example.findevents"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun initApp(view : View){
        val btInit = findViewById<Button>(R.id.btInit)

        val intent = Intent(this, LoginUsers::class.java).apply {
        }

        startActivity(intent)
    }
}