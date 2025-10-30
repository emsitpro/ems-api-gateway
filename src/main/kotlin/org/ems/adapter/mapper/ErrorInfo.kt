package org.ems.adapter.mapper

data class ErrorInfo(
    var status: Int,
    var code: String,
    var message: String?
)