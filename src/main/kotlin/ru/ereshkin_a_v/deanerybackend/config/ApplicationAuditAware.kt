package ru.ereshkin_a_v.deanerybackend.config

import org.springframework.data.domain.AuditorAware
import org.springframework.lang.NonNull
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import ru.ereshkin_a_v.deanerybackend.deputydean.entities.DeputyDean
import java.util.*

class ApplicationAuditAware : AuditorAware<Long> {
    @NonNull
    override fun getCurrentAuditor(): Optional<Long> {
        val authentication =
            SecurityContextHolder
                .getContext()
                .authentication
        if (authentication == null ||
            !authentication.isAuthenticated ||
            authentication is AnonymousAuthenticationToken
        ) {
            return Optional.empty()
        }

        val deputyDeanPrincipal: DeputyDean = authentication.principal as DeputyDean
        return Optional.ofNullable(deputyDeanPrincipal.id)
    }
}