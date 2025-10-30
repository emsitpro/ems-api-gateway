package org.ems.application.usecase

import org.ems.application.dto.ApiRequestLog

interface ApiRequestLogUseCase {
    fun createLog(request: ApiRequestLog)
}