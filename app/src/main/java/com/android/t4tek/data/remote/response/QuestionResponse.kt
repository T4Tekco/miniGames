package com.android.t4tek.data.remote.response

import androidx.annotation.Keep
import com.android.t4tek.domain.json_model.JsonQuestionListGame
import com.squareup.moshi.Json


@Keep
class QuestionResponse(
    @Json(name = "list_question")
    val jsonQuestionListGame : List<JsonQuestionListGame>
)

