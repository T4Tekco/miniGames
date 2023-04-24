package com.android.t4tek.domain.repository

import com.android.t4tek.domain.json_model.JsonQuestionListGame
import com.android.t4tek.domain.result_handler.DataResult

interface QuestionRepository {
    suspend fun getQuestion() : DataResult<List<JsonQuestionListGame>>
}