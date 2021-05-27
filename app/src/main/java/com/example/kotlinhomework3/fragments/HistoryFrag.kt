package com.example.kotlinhomework3.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinhomework3.MainViewModel
import com.example.kotlinhomework3.R
import kotlinx.android.synthetic.main.fragment_history.*

class HistoryFrag : Fragment() {

    private val  viewModel: MainViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initObserver()
    }

    private fun initObserver() {
        viewModel.mHistoryminus.observe(this,{
            txt_minuses.text = it.toString()
        })
        viewModel.mHistoryplus.observe(this,{
            txt_pluses.text = it.toString()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }
}
