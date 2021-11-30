package com.dro.enterperform.network

data class ErrorModel(
    val errors: List<Error>
)

data class Error(
    val code: String,
    val message: String
)
