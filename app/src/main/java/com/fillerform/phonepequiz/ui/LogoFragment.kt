package com.fillerform.phonepequiz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.fillerform.phonepequiz.R

class LogoFragment : Fragment() {

    companion object {
        fun newInstance() = LogoFragment()
    }

    private lateinit var viewModel: LogoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.logo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LogoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}