package com.example.movieapptinkoff.screens.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapptinkoff.R
import com.example.movieapptinkoff.models.Film
import com.example.movieapptinkoff.models.SingleFilm
import com.example.movieapptinkoff.screens.main.MainAdapter
import com.example.movieapptinkoff.screens.main.MainFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_single_movie.view.*
import kotlinx.android.synthetic.main.item.view.*

class SingleMovieAdapter: RecyclerView.Adapter<SingleMovieAdapter.MyViewHolder>() {

    private var listSingleMovie = emptyList<SingleFilm>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_single_movie, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.name.text = listSingleMovie[position].nameRu
//        var firstGenre: String = listSingleMovie[position].genres.get(0).toString()
//        holder.itemView.item_type.text = firstGenre.substring(12, firstGenre.length - 1).capitalize() + " (" + listMovies[position].year + ")"

        Picasso.get()
            .load(listSingleMovie[position].posterUrl)
            .fit()
            .centerInside()
            .into(holder.itemView.banner)
    }

    override fun getItemCount(): Int {
        return listSingleMovie.size
    }

    fun setList(list: List<SingleFilm>){
        listSingleMovie = list

        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MyViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
//            SingleMovieFragment.clickMovie(listSingleMovie[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MyViewHolder) {
        holder.itemView.setOnClickListener(null)
    }

}