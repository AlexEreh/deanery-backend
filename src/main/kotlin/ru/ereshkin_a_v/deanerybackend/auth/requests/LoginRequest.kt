package ru.ereshkin_a_v.deanerybackend.auth.requests

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.Parameter
import jakarta.validation.constraints.NotBlank

data class LoginRequest(
    @NotBlank(message = "У студента не может не быть email")
    @JsonProperty("email")
    @Parameter(name = "E-mail адрес замдекана")
    val email: String,
    @NotBlank(message = "Студента не может войти без пароля")
    @JsonProperty("password")
    @Parameter(name = "Пароль адрес замдекана")
    val password: String
)