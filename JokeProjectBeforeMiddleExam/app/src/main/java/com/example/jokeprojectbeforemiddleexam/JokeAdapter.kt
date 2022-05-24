package com.example.jokeprojectbeforemiddleexam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.time.Instant

class JokeAdapter (val joke: Joke): RecyclerView.Adapter<JokePrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokePrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_rvjoke, parent, false)

        return JokePrototype(view)
    }

    override fun onBindViewHolder(holder: JokePrototype, position: Int) {
        holder.bind(joke)
    }

    override fun getItemCount(): Int {
        return 1
    }

}

class JokePrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvIdJoke = itemView.findViewById<TextView>(R.id.tvIdJoke)
    val tvJokeMain = itemView.findViewById<TextView>(R.id.tvJokeMain)
    val tvCreatedAt = itemView.findViewById<TextView>(R.id.tvCreatedAt)

    fun bind(joke: Joke){
        tvJokeMain.text = joke.joke
        joke.createdAt = Instant.now().toString()
        tvCreatedAt.text = joke.createdAt

    }
}
