package com.android.t4tek.data.remote

import com.android.t4tek.data.remote.response.PeopleResponse
import com.android.t4tek.data.remote.response.QuestionResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<PeopleResponse>

    suspend fun getQuestion(): Response<QuestionResponse>
}