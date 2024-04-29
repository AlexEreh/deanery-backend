package ru.ereshkin_a_v.deanerybackend.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import ru.ereshkin_a_v.deanerybackend.deputydean.repository.DeputyDeanRepository

@Configuration
open class ApplicationConfig(
    private val repository: DeputyDeanRepository
) {

    @Bean
    open fun userDetailsService(): UserDetailsService {
        return UserDetailsService { username: String ->
            val user = repository.findDeputyDeanByEmail(username)
            if (user == null) {
                throw UsernameNotFoundException("User not found")
            }
            user
        }
    }

    @Bean
    open fun authenticationProvider(): AuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService())
        authProvider.setPasswordEncoder(passwordEncoder())
        return authProvider
    }

    @Bean
    open fun auditorAware(): AuditorAware<Long> {
        return ApplicationAuditAware()
    }

    @Bean
    open fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.authenticationManager
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}