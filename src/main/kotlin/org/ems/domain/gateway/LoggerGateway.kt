package org.ems.domain.gateway

interface LoggerGateway {
    fun info(message: String)
    fun warn(message: String)
}