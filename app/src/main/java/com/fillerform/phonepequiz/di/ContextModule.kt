package com.fillerform.phonepequiz.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private val context: Context) {
    @Singleton
    @Provides
    fun context(): Context = context
}