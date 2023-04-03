package com.android.t4tek.domain.usecase

import com.android.t4tek.domain.entity.PersonEntity
import com.android.t4tek.domain.repository.UserRepository
import com.android.t4tek.domain.result_handler.AppErrorType
import com.android.t4tek.domain.result_handler.DataResult
import com.android.t4tek.domain.result_handler.StatusResult
import timber.log.Timber
import javax.inject.Inject

class FetchPersonUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    
    suspend operator fun invoke(): DataResult<List<PersonEntity>> {
        try {
            //fetch api
            val responseResult = userRepository.getPersonApi()
            if (responseResult.status == StatusResult.Success) {
                //clear all table Person
                userRepository.clearAllPerson()
                val listResponse = responseResult.dataResult!!
                //save data from api to db
                val entitiesResult = userRepository.savePersonsToDb(listResponse)
                return if (entitiesResult.status == StatusResult.Success) {
                    DataResult.resultSuccess(entitiesResult.dataResult!!)
                } else {
                    DataResult.resultError(
                        entitiesResult.appError?.errorType,
                        entitiesResult.appError?.errorMessage,
                    )
                }
            } else {
                return DataResult.resultError(
                    responseResult.appError?.errorType,
                    responseResult.appError?.errorMessage,
                )
            }
        } catch (ex: Exception) {
            return DataResult.resultError(
                AppErrorType.Unknown,
                ex.message,
            )
        }
    }
}