package org.ems.application.usecase.impl

import org.ems.application.dto.ApiRequestLog
import org.ems.application.usecase.ApiRequestLogUseCase
import org.ems.domain.gateway.ApiRequestLogGateway
import org.ems.domain.model.ApiRequestLogModel

class ApiRequestLogUseCaseImpl(val apiRequestLogGateway: ApiRequestLogGateway) : ApiRequestLogUseCase {
    override fun createLog(request: ApiRequestLog) {
        val data: ApiRequestLogModel = ApiRequestLogModel(
            null,
            request.payload
        )
        apiRequestLogGateway.create(data)
    }
}