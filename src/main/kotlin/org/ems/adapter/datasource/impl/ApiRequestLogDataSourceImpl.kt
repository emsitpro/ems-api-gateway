package org.ems.adapter.datasource.impl

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.ems.adapter.datasource.ApiRequestLogDataSource
import org.ems.adapter.datasource.repository.ApiRequestLogRepository
import org.ems.adapter.dto.ApiRequestLogDto

@ApplicationScoped
class ApiRequestLogDataSourceImpl : ApiRequestLogDataSource {
    @Inject
    lateinit var repository: ApiRequestLogRepository
    override fun createLog(requestLogDto: ApiRequestLogDto) {
       repository.createLog(requestLogDto)
    }
}