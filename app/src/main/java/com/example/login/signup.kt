package com.example.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.login.databinding.FragmentSignupBinding


class signup : Fragment() {
    private lateinit var binding: FragmentSignupBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var fulname: String
    private lateinit var password: String
    private lateinit var email: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            binding.btnsignup.setOnClickListener {
                // code nhận thông tin đăng kí ở đây
                fulname = binding.edtfullname.text.toString().trim()
                password = binding.edtpassword.text.toString().trim()
                email = binding.edtemail.text.toString().trim()

                viewModel.checkEmailAndPassword(email, password)
            }
            // lắng nghe sự kiện đki thành công
            listenerSuccessEvent()
            // lắng nghe sự kiện báo lỗi
            listenerErrorEvent()
        }

    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(viewLifecycleOwner) {
            if (it) {
                val controller = findNavController()

                DataStore(fulname, email, password)
                Toast.makeText(activity, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                val bundle = Bundle()
                bundle.putParcelable(
                    Constants.KEY_USER, User(fulname, email, password)
                )
                setFragmentResult("requestKey1",bundle)
                controller.navigate(R.id.action_signup_to_signIn)

            }
        }
    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(viewLifecycleOwner) { errMess ->
            val dialog = AlertDialog.Builder(requireActivity())
            dialog.setTitle("Error")
            dialog.setMessage(errMess)
            dialog.show()
        }
    }
}