package com.fillerform.phonepequiz

import android.app.Application
import com.fillerform.phonepequiz.di.BaseAppComponent
import com.fillerform.phonepequiz.di.ContextModule
import com.fillerform.phonepequiz.di.DaggerBaseAppComponent
import timber.log.Timber

class BaseApp : Application() {

    lateinit var baseAppComponent: BaseAppComponent

    override fun onCreate() {

        super.onCreate()

        Timber.plant(TimberDebugLogTree.getInstance())

        baseAppComponent = DaggerBaseAppComponent
            .builder()
            .contextModule(ContextModule(applicationContext))
            .build()
    }
}