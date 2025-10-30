package org.ems.adapter.gateway

import jakarta.enterprise.context.ApplicationScoped
import org.ems.domain.gateway.LoggerGateway
import org.slf4j.LoggerFactory

@ApplicationScoped
class LoggerGatewayImpl : LoggerGateway {

    private val logger = LoggerFactory.getLogger(LoggerGatewayImpl::class.java)

    override fun info(message: String) {
        logger.info(message)
    }

    override fun warn(message: String) {
        logger.warn(message)
    }
}