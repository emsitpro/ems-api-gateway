package org.ems.adapter.controller

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import io.quarkus.security.Authenticated
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.jwt.JsonWebToken
import jakarta.inject.Inject
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.POST
import org.ems.application.dto.ApiRequestLog
import org.ems.application.usecase.ApiRequestLogUseCase
import org.ems.application.usecase.impl.ApiRequestLogUseCaseImpl
import org.ems.domain.gateway.LoggerGateway

@Path("/health")
@Authenticated
class HealthCheckResource {
    @Inject
    lateinit var jwt : JsonWebToken;

    @Inject
    lateinit var log : LoggerGateway;

    @Inject
    lateinit var apiRequestLogUseCase : ApiRequestLogUseCase;

    @Inject
    lateinit var objectMapper : ObjectMapper

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun healthCheck(): String {
        log.info(jwt.subject)
        return "hello"
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun save(apiRequestLog: JsonNode){
        val json = objectMapper.writeValueAsString(apiRequestLog)
        val payload = ApiRequestLog(
            json
        )
        apiRequestLogUseCase.createLog(payload)
    }

}
