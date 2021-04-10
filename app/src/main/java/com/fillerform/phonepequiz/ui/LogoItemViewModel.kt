package com.fillerform.phonepequiz.ui

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import com.fillerform.phonepequiz.di.GlideApp
import com.fillerform.phonepequiz.repo.model.Logo

class LogoItemViewModel() {
    val logoPath = ObservableField<String>()

    fun setLogo(logo: Logo) {
        this.logoPath.set(logo.imgUrl)
    }
}

@BindingAdapter("glideImgSrc")
fun glideImgSrc(v: ImageView, imagePath: String?) {
    imagePath ?: return
    GlideApp
        .with(v)
        .asDrawable()
        .centerCrop()
        .load(imagePath)
        .into(v)
}