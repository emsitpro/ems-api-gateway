package org.ems.adapter.datasource.repository

import org.ems.adapter.dto.ApiRequestLogDto

interface ApiRequestLogRepository {
    fun createLog(request: ApiRequestLogDto)
}