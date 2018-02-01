package com.github.teamapple.gencon.persentaion


sealed class Result<T> {

    //class InProgress<T> : Result<T>(true)

    data class Success<T>(var data: T) : Result<T>(false)
    data class Failure<T>(val error: Throwable) : Result<T>(false)
    companion object {
        fun <T> inProgress(): Result<T> = InProgress()

        fun <T> success(data: T): Result<T> = Success(data)

        fun <T> failure(errror: Throwable): Result<T> = Failure(errror)
    }
}
