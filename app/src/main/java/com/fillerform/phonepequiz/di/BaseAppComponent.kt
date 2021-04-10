package com.fillerform.phonepequiz.di

import com.fillerform.phonepequiz.ui.LandingFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ContextModule::class,
        UtilModule::class
    ]
)
interface BaseAppComponent {

    fun inject(landingFragment: LandingFragment)
}



