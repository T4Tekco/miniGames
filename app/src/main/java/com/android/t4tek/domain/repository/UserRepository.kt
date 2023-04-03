package com.android.t4tek.domain.repository

import androidx.annotation.WorkerThread
import com.android.t4tek.domain.entity.PersonEntity
import com.android.t4tek.domain.json_model.JsonPerson
import com.android.t4tek.domain.result_handler.DataResult

interface UserRepository {

    suspend fun getPersonApi(): DataResult<List<JsonPerson>>
    suspend fun savePersonsToDb(persons: List<JsonPerson>): DataResult<List<PersonEntity>>
    suspend fun clearAllPerson(): DataResult<Boolean>
}