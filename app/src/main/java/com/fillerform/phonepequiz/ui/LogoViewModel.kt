package com.fillerform.phonepequiz.ui

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.fillerform.phonepequiz.repo.model.Logo

class LogoViewModel : ViewModel() {
    val logoPath = ObservableField<String>()
    val logoName = ObservableField<String>()

    fun setLogo(logo: Logo) {
        this.logoPath.set(logo.imgUrl)
        this.logoName.set(logo.name)
    }
}