package org.ems.adapter.datasource.repository

import io.quarkus.hibernate.orm.panache.PanacheRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import org.ems.adapter.jpa.ApiRequestLogJpa

@ApplicationScoped
@Transactional
class JpaApiRequestLog : PanacheRepository<ApiRequestLogJpa> {
}