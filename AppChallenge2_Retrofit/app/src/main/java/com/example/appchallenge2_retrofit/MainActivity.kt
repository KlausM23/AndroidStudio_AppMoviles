package com.example.appchallenge2_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var pokemon: Pokemon
    lateinit var pokemonAdapter: PokemonAdapter

    //no inicializar variables aqui pipi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btSearch = findViewById<Button>(R.id.btSearch)

        btSearch.setOnClickListener {
            searchPokemon()
        }
    }

    private fun searchPokemon() {
        val etDescription = findViewById<TextInputEditText>(R.id.etDescription)
        val description = etDescription.text.toString()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PokemonService::class.java)

        val request = service.getPokemonInfo(description)

        val rvPokemon = findViewById<RecyclerView>(R.id.rvPokemon)

        request.enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                pokemon = response.body()!!

                pokemonAdapter = PokemonAdapter(pokemon)

                rvPokemon.adapter = pokemonAdapter
                rvPokemon.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                Log.d("MainActivity", t.toString())
            }

        })
    }
}