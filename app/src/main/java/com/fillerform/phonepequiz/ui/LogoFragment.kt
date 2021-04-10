package com.fillerform.phonepequiz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.fillerform.phonepequiz.databinding.LogoFragmentBinding

class LogoFragment : Fragment() {

    private val safeArgs: LogoFragmentArgs by navArgs()
    private val logo by lazy {
        safeArgs.logo
    }

    private lateinit var binder: LogoFragmentBinding
    private lateinit var viewModel: LogoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = LogoFragmentBinding.inflate(inflater, container, false)
        return binder.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LogoViewModel::class.java)
        binder.vm = viewModel

        viewModel.setLogo(logo)
    }

}