package com.fillerform.phonepequiz.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fillerform.phonepequiz.repo.model.Logo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.io.InputStream
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class QuizDataSource @Inject constructor(
    private val context: Context,
    private val gson: Gson
) {
    private val quizData: MutableLiveData<List<Logo>> = MutableLiveData()
    suspend fun getQuiz(): LiveData<List<Logo>> {
        withContext(Dispatchers.IO) {
            refreshQuizData()
        }
        return quizData
    }

    private suspend fun refreshQuizData() {
        val quiz: ArrayList<Logo> = ArrayList()
        var inputStream: InputStream? = null
        try {
            inputStream = context.assets.open("logo.json")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            with(
                gson.fromJson<ArrayList<Logo>?>(
                    String(buffer, Charsets.UTF_8),
                    object : TypeToken<ArrayList<Logo?>?>() {}.type
                )
            ) {
                this ?: return@with
                quiz.addAll(this)
            }
        } catch (e: Exception) {
            Timber.d(e, "Asset loading exception")
        } finally {
            inputStream?.close()
        }

        withContext(Dispatchers.Main) {
            quizData.value = quiz
        }
    }
}