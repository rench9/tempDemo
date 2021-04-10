package com.fillerform.phonepequiz.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.fillerform.phonepequiz.BaseApp
import com.fillerform.phonepequiz.databinding.LandingFragmentBinding
import com.fillerform.phonepequiz.repo.QuizDataSource
import kotlinx.coroutines.launch
import javax.inject.Inject

class LandingFragment : Fragment() {

    @Inject
    lateinit var quizDataSource: QuizDataSource

    private lateinit var binder: LandingFragmentBinding
    private lateinit var viewModel: LandingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = LandingFragmentBinding.inflate(inflater, container, false)
        return binder.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (requireContext().applicationContext as? BaseApp)?.baseAppComponent?.inject(this)
            ?: throw IllegalStateException("Data source not available.")
        viewModel = ViewModelProvider(this).get(LandingViewModel::class.java)
        loadQuiz()
    }

    private fun loadQuiz() {
        binder.rvContainer.adapter = viewModel.logoItemAdapter
        lifecycleScope.launch {
            quizDataSource.getQuiz().observe(viewLifecycleOwner, viewModel.quizDataObserver)
        }
    }


}