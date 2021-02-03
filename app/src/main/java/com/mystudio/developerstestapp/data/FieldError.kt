package com.mystudio.developerstestapp.data

data class FieldError(val defaultMessage: String,
                      val objectName: String,
                      val field: String,
                      val rejectedValue: String?,
                      val code: String?)