package com.android.t4tek.data.repository

import com.android.t4tek.data.local.AppDatabase
import com.android.t4tek.data.remote.ApiHelper
import com.android.t4tek.data.remote.response.QuestionResponse
import com.android.t4tek.domain.BaseRepository
import com.android.t4tek.domain.json_model.JsonQuestionListGame
import com.android.t4tek.domain.repository.QuestionRepository
import com.android.t4tek.domain.result_handler.AppErrorType
import com.android.t4tek.domain.result_handler.DataResult
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val db : AppDatabase,
    private val apiHelper: ApiHelper
) : QuestionRepository, BaseRepository() {
    override suspend fun getQuestion(): DataResult<List<JsonQuestionListGame>> {
        try {
            val response = apiHelper.getUsers()
            if(response.isSuccessful){
                val questionResponse = response.body() as QuestionResponse
                return DataResult.resultSuccess(questionResponse.jsonQuestionListGame)
            }
            return DataResult.resultSuccess(emptyList())
        }catch (e: Exception){
            return DataResult.resultError(AppErrorType.FetchApiException,e.stackTraceToString())
        }
    }

}