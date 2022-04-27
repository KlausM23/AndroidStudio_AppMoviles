package com.example.findevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class LoginUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_users)
    }

    fun registerUser(view: View){
        val btRegister = findViewById<Button>(R.id.btRegister)

        val intent = Intent(this, RegisterUsers::class.java).apply {

        }
        startActivity(intent)
    }
}