package com.example.movieapptinkoff.screens.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.movieapptinkoff.R
import com.example.movieapptinkoff.databinding.FragmentDetailBinding
import com.example.movieapptinkoff.models.Film
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private var mBinding: FragmentDetailBinding?= null
    private val binding get() = mBinding!!
    lateinit var currentMovie: Film

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentDetailBinding.inflate(layoutInflater, container, false)
//        currentMovie = arguments?.getSerializable("movie") as Film
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun init() {
        val viewModel = ViewModelProvider(this)[DetailFragmentViewModel::class.java]

        Picasso.get()
            .load(arguments?.getString("posterUrl"))
            .fit()
            .centerInside()
            .into(binding.banner)

        binding.name.text = arguments?.getString("nameRu")
//        var genres = arguments?.getString("genres")
//        var countries = arguments?.getString("countries")
        binding.genres.text = arguments?.getString("genres")
        binding.countries.text = arguments?.getString("countries")
        binding.year.text = arguments?.getString("year")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}