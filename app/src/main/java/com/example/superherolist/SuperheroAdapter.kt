package com.example.superherolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class SuperheroAdapter(
    private val superheroes: List<Superhero>,
    val callBack: (result: String) -> Unit
) :
    RecyclerView.Adapter<SuperheroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val listItemViewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.superhero_list_layout, parent, false)
        return SuperheroViewHolder(listItemViewHolder)
    }

    override fun getItemCount(): Int = superheroes.size

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.name.text = superheroes[position].name
        Glide.with(holder.itemView)
            .load(superheroes[position].images.xs)
            .into(holder.image)
    }

}

class SuperheroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.superheroName)
    val image: ImageView = itemView.findViewById(R.id.superheroImage)
}