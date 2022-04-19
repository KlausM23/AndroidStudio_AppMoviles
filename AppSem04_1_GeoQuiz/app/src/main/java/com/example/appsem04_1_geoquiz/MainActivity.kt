package com.example.appsem04_1_geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var position = 0
    var sizeQuestions = 0
    var score = 0
    var verifyQuestion = false
    var fails = 0

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

        sizeQuestions = questions.size - 1
    }

    private fun validationSizeQuestions(){
        if(position == sizeQuestions){
            position = 0
        }else{
            position++
        }
    }

    private fun setupViews() {
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val tvSize = findViewById<TextView>(R.id.tvNumberQuestion)
        val tvScore = findViewById<TextView>(R.id.tvScore)
        val tvFail = findViewById<TextView>(R.id.tvFail)

        //muestra en el textView el valor del arreglo
        tvQuestion.text = questions[position].sentence
        tvSize.text = "Pregunta ${(position + 1)}"
        tvScore.text = "Puntaje $score"
        tvFail.text = "Errores $fails"
        /*
        fun nextQuestion(){
            btNext.setOnClickListener {
                validationSizeQuestions()
                tvSize.text = "Pregunta " + (position+1).toString()
                tvQuestion.text = questions[position].sentence
            }
        }*/

        btYes.setOnClickListener { //funcion que permite hacer una accion al presioanr click ahi
            if (questions[position].answer == true){
                if (score != position +1){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
                    score++
                    tvScore.text = "Puntaje $score"
                }else{
                    Toast.makeText(this, "Pase a la siguiente pregunta", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
                }

                verifyQuestion = true
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
                fails++
                tvFail.text = "Errores $fails"
                if (fails == 3) {
                    finish()
                }

            }
        }

        btNo.setOnClickListener {
            if (!questions[position].answer == true){
                if (score != position +1){
                    Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
                    score++
                    tvScore.text = "Puntaje $score"
                }else{
                    Toast.makeText(this, "Pase a la siguiente pregunta", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
                }
                verifyQuestion = true
            }else{
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
                fails++
                tvFail.text = "Errores $fails"
                if (fails == 3) {
                    finish()
                }

            }
        }

        btNext.setOnClickListener {
            if(verifyQuestion){
                validationSizeQuestions()
                tvSize.text = "Pregunta ${(position + 1)}"
                tvQuestion.text = questions[position].sentence
                verifyQuestion = false
            }else{
                Toast.makeText(this, "Conteste la pregunta primero", Toast.LENGTH_LONG).show() // metodo long es para mostrar el texto mayor tiempo
            }
        }


    }
}

/*
1. Validacion. que no pase a sgte si no se respondio - ok
2. que valide el tamaño del arrayL - ok
3. puntaje - ok
4. Si fallas 3 veces el juego termina - ok
5. Tienes 2 opciones para responder una pregunta - ok
6. que se seleccione continentes / temas
* */