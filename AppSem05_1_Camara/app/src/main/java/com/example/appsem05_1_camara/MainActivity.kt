package com.example.appsem05_1_camara

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private val CAMERA_REQUEST_CODE = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btRequest = findViewById<Button>(R.id.btRequest)

        btRequest.setOnClickListener { //metodo para cuando haga click
            checkCamaraPermission()
        }


    }

    private fun checkCamaraPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            //PERMISO RECHAZADO
            requestCameraPermission()
        }else{
            //ya tengo el permiso
            Toast.makeText(this, "Ya se cuenta con acceso a la camara", Toast.LENGTH_SHORT).show()
        }
    }

    private fun requestCameraPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)){
            //si el usuario ya rechazo el permiso anteriormente, que vaya a ajustes
            Toast.makeText(this, "Rechazo el permiso anteriormente. Habilitelo manualmente!", Toast.LENGTH_SHORT).show()
        }else{
            //si el usuario nunca ha aceptado ni rechazado, le pedimos que acepte el permiso
            Toast.makeText(this, "Debe aceptar el permiso", Toast.LENGTH_SHORT).show()

            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
        }
    }

    // voy a escuchar la repsuesta del usuario
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
            CAMERA_REQUEST_CODE -> {
                if(grantResults.isNotEmpty() && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    //permiso aceptado por el usuario
                    // aca se llama a cualquier funcionalidad que quiera hacer
                    Toast.makeText(this, "Se autorizo el acceso a la camara", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "El permiso ha sido denegado", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }
}