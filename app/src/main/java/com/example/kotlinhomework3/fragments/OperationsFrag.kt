package com.example.kotlinhomework3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinhomework3.MainViewModel
import com.example.kotlinhomework3.R
import kotlinx.android.synthetic.main.fragment_operations.*

class OperationsFrag : Fragment() {
    private val  viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_operations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_add.setOnClickListener { viewModel.incrementCount() }
        btn_minus.setOnClickListener { viewModel.decrementCount() }
    }

}