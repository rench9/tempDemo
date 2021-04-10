package com.fillerform.phonepequiz.ui

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.fillerform.phonepequiz.repo.model.Logo
import timber.log.Timber

class LandingViewModel() : ViewModel() {
    val logoItemAdapter by lazy {
        LogoItemAdapter()
    }

    val quizDataObserver = Observer<List<Logo>> {
        Timber.e("DATA: ${it.size}")
        logoItemAdapter.setItems(it)
    }
}