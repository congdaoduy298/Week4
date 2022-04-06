package com.example.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.login.databinding.ActivityMainBinding
//import com.example.login.databinding.ActivitySigninBinding
import com.example.login.MainViewModel
import com.example.login.databinding.GridViewRestaurantBinding

class GridView : AppCompatActivity() {
    private lateinit var binding: GridViewRestaurantBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.grid_view_restaurant)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val data = DataRestaurant.getRes()
        val n_cols = 2;
        val gm = GridLayoutManager(this, n_cols)
        val adapter = RestaurantAdapter(data)
        binding.restaurantGrid.layoutManager=gm
        binding.restaurantGrid.adapter=adapter
        binding.btnLinearView.setOnClickListener {
            val intent: Intent = Intent(this@GridView, ListRes::class.java)
            startActivity(intent)
        }

    }
}