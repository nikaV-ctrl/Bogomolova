package com.example.movieapptinkoff.screens.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapptinkoff.R
import com.example.movieapptinkoff.models.Film
import com.example.movieapptinkoff.models.Genre
import kotlinx.android.synthetic.main.item.view.*
import com.squareup.picasso.Picasso

class MainAdapter: RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private var listMovies = emptyList<Film>()
    private var listGenres = emptyList<Genre>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.item_name.text = listMovies[position].nameRu
        var firstGenre: String = listMovies[position].genres.get(0).toString()
        holder.itemView.item_type.text = firstGenre.substring(12, firstGenre.length - 1).capitalize() + " (" + listMovies[position].year + ")"

        Picasso.get()
            .load(listMovies[position].posterUrl)
            .fit()
            .centerInside()
            .into(holder.itemView.item_banner)

    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    fun setList(list: List<Film>){
        listMovies = list
//        listGenres = listTwo

        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            MainFragment.clickMovie(listMovies[holder.adapterPosition])
//            MainFragment.clickMovie(listGenres[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener(null)
    }



}