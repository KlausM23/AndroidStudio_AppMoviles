package com.example.appchallenge2_retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class PokemonAdapter (val pokemon: Pokemon): RecyclerView.Adapter<PokemonPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_pokemon, parent, false)

        return PokemonPrototype(view)
    }

    override fun onBindViewHolder(holder: PokemonPrototype, position: Int) {
        holder.bind(pokemon)
    }

    override fun getItemCount(): Int {
        return 1
        //return pokemon.size
    }

}

class PokemonPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<TextView>(R.id.tvName)
    val tvHeight = itemView.findViewById<TextView>(R.id.tvHeight)
    val tvWeight = itemView.findViewById<TextView>(R.id.tvWeight)
    val ivPokemon = itemView.findViewById<ImageView>(R.id.ivPokemon)

    fun bind (pokemon: Pokemon){
        tvName.text = pokemon.name
        tvHeight.text = "Altura: ${pokemon.height/10.0} m"
        tvWeight.text = "Peso: ${pokemon.weight/10.0} kg"

        //mostrar el logo -> incluir glide en las dependencias
        Glide.with(itemView).load(pokemon.sprites.frontDefault).into(ivPokemon)

        //Glide.with(itemView).load(pokemon.sprites.frontDefault).into(ivPokemon)
    }
}
