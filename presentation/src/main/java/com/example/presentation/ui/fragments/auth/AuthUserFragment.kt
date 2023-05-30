package com.example.presentation.ui.fragments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.databinding.FragmentAuthUserBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AuthUserFragment : Fragment(R.layout.fragment_auth_user) {

    private val binding by viewBinding(FragmentAuthUserBinding::bind)
    private val viewModel by viewModels<AuthUserViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRequest()
    }

    private fun setupRequest() {
        binding.btnConfirm.setOnClickListener {
            if (binding.etName.text.isEmpty() && binding.etAge.text.isEmpty() && binding.etPassword.text.isEmpty()) {
                binding.etName.error = "заполните поле"
                binding.etAge.error = "заполните поле"
                binding.etPassword.error = "заполните поле"
            } else if (binding.etAge.text.isEmpty() && binding.etPassword.text.isEmpty()) {
                binding.etAge.error = "заполните поле"
                binding.etPassword.error = "заполните поле"
            } else if (binding.etPassword.text.isEmpty()) {
                binding.etPassword.error = "заполните поле"
            } else if (binding.etAge.text.isEmpty()) {
                binding.etAge.error = "заполните поле"
            } else if (binding.etName.text.isEmpty()) {
                binding.etName.error = "заполните поле"
            } else {

                val name = binding.etName.text.toString().trim()
                val age = binding.etAge.text.toString().trim().toInt()
                val password = binding.etPassword.text.toString().trim()
                viewModel.authUser(name, age, password)

                binding.etName.setText("")
                binding.etAge.setText("")
                binding.etPassword.setText("")

                viewLifecycleOwner.lifecycleScope.launch {
                    delay(2000)
                    viewModel.getUser().apply {
                        binding.etName.setText(this.name)
                        binding.etAge.setText(this.age)
                        binding.etPassword.setText(this.password)
                    }
                }
                val action: NavDirections =
                    AuthUserFragmentDirections.actionAuthUserFragmentToInformationUserFragment(
                        name,
                        age,
                        password
                    )
                findNavController().navigate(action)
            }
        }
    }
}