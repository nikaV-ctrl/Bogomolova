package com.example.movieapptinkoff.screens.detail

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.movieapptinkoff.databinding.FragmentDetailBinding
import com.example.movieapptinkoff.models.Film

class SingleMovieFragment : Fragment() {

    private var mBinding: FragmentDetailBinding?= null
    private val binding get() = mBinding!!
//    lateinit var currentMovie: Film

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
//        val viewModel = ViewModelProvider(this)[DetailFragmentViewModel::class.java]

//        Picasso.get()
//            .load(currentMovie.posterUrl)
//            .fit()
//            .centerInside()
//            .into(binding.banner)

//        binding.name.text = currentMovie.nameRu
//        binding.year.text = currentMovie.year
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        mBinding = null
//    }
}