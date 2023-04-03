package com.android.t4tek.domain.result_handler

data class DataResult<T>(
    val status: StatusResult,
    var dataResult: T? = null,
    var appError: AppError? = null,
) {

    companion object {
        fun <T> resultSuccess(data: T): DataResult<T> {
            return DataResult(
                status = StatusResult.Success,
                data,
            )
        }

        fun <T> resultError(
            errorType: AppErrorType? = AppErrorType.Unknown,
            errorMessage: String? = "",
            errorCode: String? = "",
            data: T? = null
        ): DataResult<T> {
            return DataResult(
                status = StatusResult.Error,
                appError = AppError(errorType=errorType!!, errorMessage = errorMessage, errorCode = errorCode),
                dataResult = data
            )
        }
    }

    override fun toString(): String {
        return "DataResult(status=$status, dataResult=$dataResult, appError=$appError)"
    }
}