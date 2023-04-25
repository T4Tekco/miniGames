package com.android.t4tek.data.remote

import com.android.t4tek.data.remote.response.PeopleResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<PeopleResponse>
}