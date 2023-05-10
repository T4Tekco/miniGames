package com.android.t4tek.domain.json_model

data class JsonQuestion(

val id: Int,
val list_question: List<JsonQuestionListGame>
)

//data class JsonQuestionListGame(
//    val id: Int,
//    val number_1: Int,
//    val number_2: Int,
//    val operator: String,
//    val result: Int
//)
data class QuestionList(
    val questions: List<JsonQuestion>

)