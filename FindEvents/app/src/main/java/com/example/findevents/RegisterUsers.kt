package com.example.findevents

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class RegisterUsers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_users)
    }

    fun registerComplete(view: View){

        //creas builder para el pop up -> asignas valores
        val builder = AlertDialog.Builder(this@RegisterUsers)
        val view = layoutInflater.inflate(R.layout.new_user_registered, null)

        //pasando la vista al builder
        builder.setView(view)

        //creando el dialog para mostrar el
        val dialog = builder.create()

        //el fondo del pop up sera transparente
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        //muestra el pop up
        dialog.show()


        val btGoLogin = view.findViewById<Button>(R.id.btGoLogin)

        btGoLogin.setOnClickListener {
            goLogin()
        }

    }

    fun goLogin(){
        val intent = Intent(this, LoginUsers::class.java).apply {

        }
        startActivity(intent)
    }
}