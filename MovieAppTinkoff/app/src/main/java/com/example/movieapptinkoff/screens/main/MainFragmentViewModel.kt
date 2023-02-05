package com.example.movieapptinkoff.screens.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapptinkoff.MainActivity
import com.example.movieapptinkoff.data.retrofit.RetrofitRepository
import com.example.movieapptinkoff.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel: ViewModel() {

    private val repository = RetrofitRepository()
    val myMovies: MutableLiveData<Response<MoviesModel>> = MutableLiveData()

    fun getMovies(){

        viewModelScope.launch {
            try{
                myMovies.value = repository.getMovies()
            } catch (e: Exception){
                Log.e("ERROR", e.message.toString())
            }
        }

    }

}