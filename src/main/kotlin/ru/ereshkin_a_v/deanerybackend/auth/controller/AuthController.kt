package ru.ereshkin_a_v.deanerybackend.auth.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.validation.Valid
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.ereshkin_a_v.deanerybackend.auth.requests.LoginRequest
import ru.ereshkin_a_v.deanerybackend.auth.requests.RegisterRequest
import ru.ereshkin_a_v.deanerybackend.auth.responses.AuthResponse
import ru.ereshkin_a_v.deanerybackend.auth.service.AuthService

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth Controller", description = "API для операций с аутентификацией")
@Validated
class AuthController(
    private val authService: AuthService
) {
    @Operation(
        summary = "Обновление токена авторизации"
    )
    @Valid
    @PostMapping("/refresh")
    fun refresh(
        request: HttpServletRequest,
        response: HttpServletResponse
    ) {
        return authService.refreshToken(request, response)
    }
    @Operation(
        summary = "Логин замдекана",
        description = "Позволяет зайти за замдекана"
    )
    @Valid
    @PostMapping("/login")
    fun login(
        @RequestBody request: LoginRequest
    ): AuthResponse {
        return authService.login(request)
    }

    @Operation(
        summary = "Регистрация замдекана",
        description = "Позволяет зайти за замдекана"
    )
    @Valid
    @PostMapping("/register")
    fun register(
        @RequestBody request: RegisterRequest
    ): AuthResponse {
        return authService.register(request)
    }
}