
package com.android.t4tek.domain.json_model

import com.squareup.moshi.Json

data class JsonQuestionListGame(
    @Json(name = "id") val id: Int,
    @Json(name = "number_1") val number_1: Int,
    @Json(name = "number_2") val number_2: Int,
    @Json(name = "operator") val operator: String,
    @Json(name = "result") val result: Int
)

