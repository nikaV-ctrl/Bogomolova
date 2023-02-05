package com.example.movieapptinkoff.screens.detail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapptinkoff.data.retrofit.RetrofitRepository
import com.example.movieapptinkoff.models.MoviesModel
import com.example.movieapptinkoff.models.SingleFilm
import kotlinx.coroutines.launch
import retrofit2.Response

class SingleMovieFragmentViewModel : ViewModel() {

    private val repository = RetrofitRepository()
    val myMovie: MutableLiveData<Response<SingleFilm>> = MutableLiveData()

    fun getOneMovie(){

        viewModelScope.launch {
            try{
                myMovie.value = repository.getOneMovie()
            } catch (e: Exception){
                Log.e("ERROR", e.message.toString())
            }
        }

    }

}