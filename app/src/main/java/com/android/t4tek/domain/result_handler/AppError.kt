package com.android.t4tek.domain.result_handler

class AppError (
    var errorType: AppErrorType = AppErrorType.Unknown,
    var errorCode: String? = "",
    var errorMessage: String? = "",
){
    override fun toString(): String {
        return "AppError(errorType=$errorType, errorCode=$errorCode, errorMessage=$errorMessage)"
    }
}