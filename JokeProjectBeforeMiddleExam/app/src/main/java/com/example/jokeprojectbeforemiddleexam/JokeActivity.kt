package com.example.jokeprojectbeforemiddleexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class JokeActivity : AppCompatActivity() {

    lateinit var jokeAdapter : JokeAdapter
    lateinit var joke : Joke

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke)

        jokesInit()
    }

    fun jokesInit(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://geek-jokes.sameerkumar.website/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(JokeService::class.java)

        val request = service.getJoke("json")

        val rvJoke = findViewById<RecyclerView>(R.id.rvJoke)

        val rbJoke = findViewById<RatingBar>(R.id.rbJoke)



        request.enqueue(object : Callback<Joke>{
            override fun onResponse(call: Call<Joke>, response: Response<Joke>) {
                joke = response.body()!!
                jokeAdapter = JokeAdapter(joke)

                rvJoke.adapter = jokeAdapter
                rvJoke.layoutManager = LinearLayoutManager(this@JokeActivity)

            }

            override fun onFailure(call: Call<Joke>, t: Throwable) {
                Log.d("MainActivity", t.toString())
            }


        })

        //bt.setOnClickListener {
        //    Toast.makeText(this, "Rating: " + rbJoke.rating.toString(), Toast.LENGTH_LONG).show()
        //}

        //rbJoke.setOnClickListener {
           // Toast.makeText(this, "Rating: " + rbJoke.rating.toString(), Toast.LENGTH_LONG).show()
        //}
/*
        rbJoke.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(this, "Rating: $rating", Toast.LENGTH_LONG).show()
        }
¨*/
    }

}