package org.ems.adapter.datasource.repository

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import org.ems.adapter.dto.ApiRequestLogDto
import org.ems.adapter.jpa.ApiRequestLogJpa

@ApplicationScoped
class ApiRequestLogRepositoryImpl : ApiRequestLogRepository {
    @Inject
    lateinit var jpaApiRequestLog: JpaApiRequestLog
    override fun createLog(request: ApiRequestLogDto) {
        val entity = ApiRequestLogJpa(
            null,
            request.payload
        )
        jpaApiRequestLog.persist(entity)
    }
}