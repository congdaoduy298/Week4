package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.login.databinding.FragmentSplashBinding

class Splash : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imagefoodhub.alpha=0f
        binding.imagefoodhub.animate().setDuration(3000).alpha(1f).withEndAction(){
            val controller=findNavController()
            controller.navigate(R.id.action_splash_to_onboardingOne)
            onCreateAnimation(android.R.anim.fade_in,true, android.R.anim.fade_out)

        }

    }

}



