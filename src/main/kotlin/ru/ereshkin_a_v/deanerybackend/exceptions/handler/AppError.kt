package ru.ereshkin_a_v.deanerybackend.exceptions.handler

data class AppError(
    val statusCode: Int,
    val message: String,
    val debugMessage: String
)