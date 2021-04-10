package com.fillerform.phonepequiz.repo.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Logo(
    val imgUrl: String,
    val name: String
) : Parcelable