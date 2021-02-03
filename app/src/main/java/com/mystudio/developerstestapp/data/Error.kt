package com.mystudio.developerstestapp.data

data class Error(val httpCode: Int,
                 val message: String,
                 val functionalCode: Int,
                 val detail: String,
                 val fields: List<FieldError> = emptyList())