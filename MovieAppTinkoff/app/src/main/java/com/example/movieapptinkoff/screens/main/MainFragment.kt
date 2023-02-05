package com.example.movieapptinkoff.screens.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapptinkoff.MAIN
import com.example.movieapptinkoff.R
import com.example.movieapptinkoff.models.Film
import com.example.movieapptinkoff.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var mBinding: FragmentMainBinding ?= null
    private val binding get() = mBinding!!
    lateinit var movieList: RecyclerView
    private val adapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.relativeLayoutTop.setOnClickListener{
            MAIN.navController.navigate(R.id.action_mainFragmentNav_self)
        }

        binding.relativeLayoutFavorite.setOnClickListener{
            MAIN.navController.navigate(R.id.action_mainFragment2_to_favoriteFragment)
        }

        init()
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun init() {

//        relativeLayoutFavorite.setOnClickListener{
////            MAIN?.navController?.navigate(R.id.action_mainFragment2_to_favoriteFragment)
//
//            MAIN.navController.navigate(R.id.favoriteFragment)
//        }

        try{
            val viewModel = ViewModelProvider(this)[MainFragmentViewModel::class.java]
            movieList = binding.movieList
            movieList.adapter = adapter
            viewModel.getMovies()
            viewModel.myMovies.observe(this, { list ->
                adapter.setList(list.body()!!.films)
            })
        } catch(e: Exception){
            Log.e("ERROR5", e.message.toString())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

    companion object{

        fun clickMovie(model: Film){
            val bundle = Bundle()
            bundle.putSerializable("movie", model)
//            MAIN.navController.navigate(R.id.action_mainFragment2_to_detailFragment, bundle)

            MAIN.navController.navigate(R.id.action_mainFragmentNav_to_singleMovieFragment, bundle)
        }
    }


}