package com.fillerform.phonepequiz.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UtilModule {
    @Module
    companion object {
        @JvmStatic
        @Singleton
        @Provides
        fun gson(): Gson = GsonBuilder().create()
    }
}