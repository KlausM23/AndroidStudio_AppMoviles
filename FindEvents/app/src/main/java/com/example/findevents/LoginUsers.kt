package com.example.findevents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class LoginUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_users)

        //obtenemos el spinner
        val spinner = findViewById<Spinner>(R.id.spinnerUserTypeLogin)

        //se obtiene los valores de la lista para mostrarlo en el spinner
        val lista = resources.getStringArray(R.array.user_type)

        //val adaptador = ArrayAdapter(this,
        //    android.R.layout.simple_spinner_item, lista)

        val adaptador = ArrayAdapter(this,
        R.layout.spinner_item_customized, lista)

        spinner.adapter = adaptador

    }

    fun registerUser(view: View){
        val btRegister = findViewById<Button>(R.id.btRegister)

        val intent = Intent(this, RegisterUsers::class.java).apply {

        }
        startActivity(intent)
    }
}