package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.login.MainViewModel
import com.example.login.databinding.FragmentSigninBinding

class SignIn : Fragment() {

    private lateinit var binding: FragmentSigninBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSigninBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lateinit var fulname: String
        lateinit var password: String
        lateinit var email: String

        lateinit var edtuser: String
        lateinit var edtpass: String

        setFragmentResultListener("requestKey1") { requestKey1, bundle ->
            let {
                val user: User? = bundle.getParcelable(Constants.KEY_USER)
                user?.let {
                    fulname = user.fullName
                    email = user.email
                    password = user.password
                }
            }
        }

        binding.signup.setOnClickListener{
            val controller=findNavController()
            controller.navigate(R.id.action_signIn_to_signup)

            //val intent : Intent = Intent(this@SignIn, signup::class.java)
            //startActivity(intent)
        }

        binding.buttonlogin.setOnClickListener {
            edtuser = binding.username.text.toString()
            edtpass = binding.password.text.toString()

            if (edtuser == email && edtpass == password) {
                val controller=findNavController()
                val bundle = Bundle()
                bundle.putParcelable(
                    Constants.KEY_USER, User(fulname, email, password)
                )
                setFragmentResult("requestKey",bundle)
                controller.navigate(R.id.action_signIn_to_profile)
            }
            else{
                Toast.makeText(activity,"Incorrect E-mail or Password!!!",Toast.LENGTH_LONG).show()
            }
        }
    }
}
