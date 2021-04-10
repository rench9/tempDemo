package com.fillerform.phonepequiz

import com.fillerform.phonepequiz.extra.SingletonNoArgExt
import timber.log.Timber

class TimberDebugLogTree private constructor() : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return "${element.lineNumber}.${super.createStackElementTag(element)}"
    }

    companion object : SingletonNoArgExt<TimberDebugLogTree>(::TimberDebugLogTree)
}