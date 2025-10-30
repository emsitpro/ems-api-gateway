package org.ems.adapter.gateway

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.ems.adapter.datasource.ApiRequestLogDataSource
import org.ems.adapter.mapper.ApiRequestLogMapper
import org.ems.domain.gateway.ApiRequestLogGateway
import org.ems.domain.model.ApiRequestLogModel

@ApplicationScoped
class ApiRequestLogGatewayImpl : ApiRequestLogGateway {
    @Inject
    lateinit var dataSource: ApiRequestLogDataSource

    override fun create(request: ApiRequestLogModel) {
       dataSource.createLog(ApiRequestLogMapper.toModel(request))
    }
}