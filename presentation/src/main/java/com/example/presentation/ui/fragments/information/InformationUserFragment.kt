package com.example.presentation.ui.fragments.information

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.databinding.FragmentInformationUserBinding

class InformationUserFragment : Fragment(R.layout.fragment_information_user) {

    private val binding by viewBinding(FragmentInformationUserBinding::bind)
    private val args by navArgs<InformationUserFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        initialize()
        setupListeners()
    }

    private fun getData() {
        binding.tvName.text = args.name
        binding.tvAge.text = args.age.toString()
        binding.tvPassword.text = args.password
    }

    private fun initialize() {
        binding.tvName.isVisible = false
        binding.tvAge.isVisible = false
        binding.tvPassword.isVisible = false
    }

    private fun setupListeners() = with(binding) {
        btnShow.setOnClickListener {
            tvName.isVisible = false
            tvAge.isVisible = false
            tvPassword.isVisible = false
            btnShow.isVisible = false
            btnDoNotShow.isVisible = true
        }
        btnDoNotShow.setOnClickListener {
            tvName.isVisible = true
            tvAge.isVisible = true
            tvPassword.isVisible = true
            btnShow.isVisible = true
            btnDoNotShow.isVisible = false
        }
    }
}