package com.example.appsem04_1_geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()

        var question = Question("¿Es lima la capital de Perú?", true)

        questions.add(question)

        questions.add(Question("¿Es lima la capital de Chile?", false))
        questions.add(Question("¿Es Ica la capital de Chile?", false))
        questions.add(Question("¿Es La Paz la capital de Bolivia?", true))
        questions.add(Question("¿Es Santiago la capital de Venezuela?", false))
        questions.add(Question("¿Es Santiago la capital de Chile?", true))
        questions.add(Question("¿Es Bs As la capital de Bolivia?", false))
        questions.add(Question("¿Es Medellin la capital de Venezuela?", false))
        questions.add(Question("¿Es Montevideo la capital de Uruguay?", true))
        questions.add(Question("¿Es Bs As la capital de Argentina?", true))
    }

    private fun setupViews() {
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)

        //muestra en el textView el valor del arreglo
        tvQuestion.text = questions[position].sentence


        btYes.setOnClickListener { //funcion que permite hacer una accion al presioanr click ahi
            if (questions[position].answer == true){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
            }
        }

        btNo.setOnClickListener {
            if (!questions[position].answer == true){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
            }
        }

        btNext.setOnClickListener {
            position++
            tvQuestion.text = questions[position].sentence
        }

    }
}