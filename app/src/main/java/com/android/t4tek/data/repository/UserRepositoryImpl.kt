package com.android.t4tek.data.repository

import com.android.t4tek.data.remote.ApiHelper
import com.android.t4tek.data.local.AppDatabase
import com.android.t4tek.data.remote.response.PeopleResponse
import com.android.t4tek.domain.BaseRepository
import com.android.t4tek.domain.entity.PersonEntity
import com.android.t4tek.domain.json_model.JsonPerson
import com.android.t4tek.domain.repository.UserRepository
import com.android.t4tek.domain.result_handler.AppErrorType
import com.android.t4tek.domain.result_handler.DataResult
import timber.log.Timber
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val db: AppDatabase,
    private val apiHelper: ApiHelper
) : UserRepository, BaseRepository() {

    override suspend fun getPersonApi(): DataResult<List<JsonPerson>> {
        try {
            val response = apiHelper.getUsers()
            if (response.isSuccessful) {
                val peopleResponse = response.body() as PeopleResponse
                if (peopleResponse.isSuccess()) {
                    return DataResult.resultSuccess(peopleResponse.peoples)
                }
            }
            return DataResult.resultSuccess(emptyList())
        } catch (ex: Exception) {
            return DataResult.resultError(AppErrorType.FetchApiException, errorMessage = ex.stackTraceToString())
        }
    }

    override suspend fun savePersonsToDb(persons: List<JsonPerson>): DataResult<List<PersonEntity>> {
        return try {
            val list = persons.map {  it.toEntity()}.toList()
            db.personDao().insertAll(*list.toTypedArray())
            val dbList = db.personDao().getAll()
            DataResult.resultSuccess(dbList)
        } catch (ex: Exception) {
            Timber.tag("UserRepositoryImpl").i("ex: ${ex}")
            DataResult.resultError(AppErrorType.DatabaseException, errorMessage = ex.message)
        }
    }

    override suspend fun clearAllPerson(): DataResult<Boolean> {
        db.personDao().clearAll()
        return DataResult.resultSuccess(true)
    }
}