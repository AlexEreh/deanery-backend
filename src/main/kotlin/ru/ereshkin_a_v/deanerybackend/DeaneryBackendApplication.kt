package ru.ereshkin_a_v.deanerybackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
@EntityScan("ru.ereshkin_a_v.deanerybackend")
class DeaneryBackendApplication

fun main(args: Array<String>) {
    runApplication<DeaneryBackendApplication>(*args)
}

@Bean
fun corsConfigurer(): WebMvcConfigurer {
    return object : WebMvcConfigurer {
        override fun addCorsMappings(registry: CorsRegistry) {
            registry
                .addMapping("/graphql")
                .allowedMethods("GET", "POST", "HEAD", "OPTIONS")
        }
    }
}
