package com.example.login

import android.content.Intent
import android.os.Bundle
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.login.databinding.FragmentProfileBinding

class profile : Fragment() {

    private lateinit var binding: FragmentProfileBinding
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
        binding = FragmentProfileBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setFragmentResultListener("requestKey") { requestKey, bundle ->
            let {
                val user: User? = bundle.getParcelable(Constants.KEY_USER)
                user?.let {
                    binding.fullname.text = "${user.fullName}"
                    binding.email.text = "${user.email}"
                    binding.phone.text = ""
                }
            }

            dialogFullname()
            dialogEmail()
            dialogPhone()
        }
    }
    private fun dialogFullname(){
        binding.fullname.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            val inflater=layoutInflater
            val dialogLayout=inflater.inflate(R.layout.dialog_fullname,null)
            val fn : EditText = dialogLayout.findViewById(R.id.dialog_name)
            with(builder){
                setTitle("Enter your name")
                setPositiveButton("Ok"){
                    dialog,which -> binding.fullname.text = fn.text.toString()
                }
                setNegativeButton("Cancel"){_,_ ->
                }
                setView(dialogLayout)
                builder.show()
            }
        }
    }
    private fun dialogEmail(){
        binding.email.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            val inflater=layoutInflater
            val dialogLayout=inflater.inflate(R.layout.dialog_email,null)
            val e : EditText = dialogLayout.findViewById(R.id.dialog_mail)
            with(builder){
                setTitle("Enter your email")
                setPositiveButton("Ok"){
                        dialog,which -> binding.email.text = e.text.toString()
                }
                setNegativeButton("Cancel"){_,_ ->
                }
                setView(dialogLayout)
                builder.show()
            }
        }

    }
    private fun dialogPhone(){
        binding.phone.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            val inflater=layoutInflater
            val dialogLayout=inflater.inflate(R.layout.dialog_phone,null)
            val p : EditText = dialogLayout.findViewById(R.id.dialogphone)
            with(builder){
                setTitle("Enter your phone")
                setPositiveButton("Ok"){
                        dialog,which -> binding.phone.text = p.text.toString()
                }
                setNegativeButton("Cancel"){_,_ ->
                }
                setView(dialogLayout)
                builder.show()
            }
        }
    }
}