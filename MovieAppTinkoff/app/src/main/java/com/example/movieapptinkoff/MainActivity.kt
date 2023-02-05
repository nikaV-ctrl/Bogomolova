package com.example.movieapptinkoff

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.movieapptinkoff.databinding.ActivityMainBinding
import com.example.movieapptinkoff.screens.favorite.FavoriteFragment
import com.example.movieapptinkoff.screens.main.MainFragment

class MainActivity : AppCompatActivity() {

    private lateinit var relativeLayoutTop: RelativeLayout
    private lateinit var relativeLayoutFavorite: RelativeLayout
    private lateinit var frameLayout: FrameLayout
    private lateinit var manager: FragmentManager
    private lateinit var transaction: FragmentTransaction
    private lateinit var mainFragment: MainFragment
    private lateinit var favoriteFragment: FavoriteFragment

    private var mBinding: ActivityMainBinding ?= null
    private val binding get() = mBinding!!
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this
        navController = Navigation.findNavController(this, R.id.nav_host)


        val connectionManager: ConnectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectionManager.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        if(!isConnected){
            MAIN.navController.navigate(R.id.action_mainFragmentNav_to_lostConnectionFragment)
        }


//        setContentView(R.layout.activity_main)

//        relativeLayoutTop = findViewById(R.id.relativeLayoutTop)
//        relativeLayoutFavorite = findViewById(R.id.relativeLayoutFavorite)
//        frameLayout = findViewById(R.id.frameLayout)
//        var relativeLayoutTop = findViewById(R.id.relativeLayoutTop) as RelativeLayout

//        relativeLayoutTop.setOnClickListener{
//            val intent = Intent(this, SingleMovie::class.java)
//            startActivity(intent);
//        }

//        manager = supportFragmentManager
//        transaction = manager.beginTransaction()
//        transaction.replace(R.id.frameLayout, MainFragment())
//        transaction.addToBackStack(null)
//        transaction.commit()
//
//        relativeLayoutTop.setOnClickListener{
//            manager = supportFragmentManager
//            transaction = manager.beginTransaction()
//            transaction.replace(R.id.frameLayout, MainFragment())
//            transaction.addToBackStack(null)
//            transaction.commit()
//        }
//
//        relativeLayoutFavorite.setOnClickListener{
//            manager = supportFragmentManager
//            transaction = manager.beginTransaction()
//            transaction.replace(R.id.frameLayout, FavoriteFragment())
//            transaction.addToBackStack(null)
//            transaction.commit()
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

}