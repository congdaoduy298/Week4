package com.example.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.login.databinding.FragmentGridViewRestaurantBinding
import com.example.login.databinding.FragmentRecycleViewRestaurantBinding


class GridViewRestaurantFragment : Fragment() {
    lateinit var binding: FragmentGridViewRestaurantBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGridViewRestaurantBinding.inflate(inflater, container, false)
        val data = DataRestaurant.getRes()
        val n_cols = 2;
        val gm = GridLayoutManager(activity, n_cols)
        val adapter = RestaurantAdapter(data)
        binding.restaurantGrid.layoutManager=gm
        binding.restaurantGrid.adapter=adapter
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLinearView.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_gridViewRestaurantFragment_to_recycleViewRestaurantFragment)
        }

        binding.backButton.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_gridViewRestaurantFragment_to_welCome)
        }

        binding.ivProfile.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_gridViewRestaurantFragment_to_profile)
        }
    }


}