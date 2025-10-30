package org.ems.adapter.infrastructure.configuration

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Produces
import jakarta.inject.Inject
import org.ems.application.usecase.ApiRequestLogUseCase
import org.ems.application.usecase.impl.ApiRequestLogUseCaseImpl
import org.ems.domain.gateway.ApiRequestLogGateway

@ApplicationScoped
class ComponentConfiguration {

    @Inject
    lateinit var apiRequestLogGateway: ApiRequestLogGateway

    @Produces
    fun apiRequestLogUseCase(): ApiRequestLogUseCase {
        return ApiRequestLogUseCaseImpl(apiRequestLogGateway)
    }
}