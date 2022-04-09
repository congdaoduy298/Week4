package com.example.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login.databinding.FragmentRecycleViewRestaurantBinding


class RecycleViewRestaurantFragment : Fragment() {
    lateinit var binding: FragmentRecycleViewRestaurantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecycleViewRestaurantBinding.inflate(inflater, container, false)
        val data = DataRestaurant.getRes()
        val lm = LinearLayoutManager(activity)
        val adapter = RestaurantAdapter(data)
        binding.restaurantLinear.layoutManager=lm
        binding.restaurantLinear.adapter=adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnGridView.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_recycleViewRestaurantFragment_to_gridViewRestaurantFragment)
        }

        binding.backButton.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_recycleViewRestaurantFragment_to_welCome)
        }

        binding.profileButton.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_recycleViewRestaurantFragment_to_profile)
        }
    }
}