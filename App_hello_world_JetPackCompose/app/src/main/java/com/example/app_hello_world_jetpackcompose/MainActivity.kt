package com.example.app_hello_world_jetpackcompose

import android.os.Bundle
import android.security.identity.PersonalizationData
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app_hello_world_jetpackcompose.ui.theme.App_hello_world_JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            //Text(text = "Este es mi primer programa...") //
            PersonalData(name = "David")
        }
    }
}

@Composable
private fun PersonalData(name : String){

    MaterialTheme() {
        Column() {
            Text(text = "Mi nombre es $name", style = MaterialTheme.typography.h4)
            Text(text = "Seccion WX71")
            Text(text = "Viernes 01/04/2022")
        }
    }

}

@Preview
@Composable
fun PreviewPersonalData(){
    PersonalData(name = "App para dispositivos moviles")
}