package org.ems.adapter.mapper

import org.ems.adapter.dto.ApiRequestLogDto
import org.ems.domain.model.ApiRequestLogModel

object ApiRequestLogMapper {

    fun toModel(entity: ApiRequestLogModel): ApiRequestLogDto =
        ApiRequestLogDto(
            entity.payload
        )

}