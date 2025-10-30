package org.ems.adapter.datasource

import org.ems.adapter.dto.ApiRequestLogDto

interface ApiRequestLogDataSource {
    fun createLog(requestLogDto: ApiRequestLogDto)
}