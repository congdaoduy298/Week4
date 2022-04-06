package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.login.databinding.FragmentWelcomeBinding


class WelCome : Fragment() {

    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentWelcomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imagephone.setOnClickListener {
            val controller= findNavController()
            controller.navigate(R.id.action_welCome_to_signup)
            //val intent: Intent= Intent(this@WelCome, signup::class.java)
            //startActivity(intent)
        }

        binding.textsignin.setOnClickListener {
            val controller= findNavController()
            controller.navigate(R.id.action_welCome_to_signIn)
            //val intent: Intent= Intent(this@WelCome, SignIn::class.java)
            //startActivity(intent)
        }


    }
}