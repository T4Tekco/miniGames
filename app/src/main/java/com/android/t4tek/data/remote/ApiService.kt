package com.android.t4tek.data.remote

import com.android.t4tek.data.remote.response.JsonListGame
import com.android.t4tek.data.remote.response.PeopleResponse
import com.android.t4tek.data.remote.response.QuestionResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("astros.json")
    suspend fun getUsers(): Response<PeopleResponse>

    @GET("question.json")
    suspend fun getQuestion(): Response<QuestionResponse>

    @GET("list_game.json")
    suspend fun getListGame(): Response<JsonListGame>

}