package com.example.movieapptinkoff.screens.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapptinkoff.MAIN
import com.example.movieapptinkoff.R
import com.example.movieapptinkoff.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private var mBinding: FragmentFavoriteBinding?= null
    private val binding get() = mBinding!!
    lateinit var favoriteList: RecyclerView
//    private val adapter by lazy { MainAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.relativeLayoutTop.setOnClickListener{
            MAIN.navController.navigate(R.id.action_favoriteFragment_to_mainFragment2)
        }

        binding.relativeLayoutFavorite.setOnClickListener{
            MAIN.navController.navigate(R.id.action_favoriteFragment_self)
        }

        init()
    }

    private fun init() {

        val viewModel = ViewModelProvider(this).get(FavoriteFragmentViewModel::class.java)
        favoriteList = binding.favoriteList
//        favoriteList.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}