package org.ems.domain.gateway

import org.ems.domain.model.ApiRequestLogModel

interface ApiRequestLogGateway {
    fun create(request: ApiRequestLogModel)
}