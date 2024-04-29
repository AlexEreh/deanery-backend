package ru.ereshkin_a_v.deanerybackend.auth.requests

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank


@Schema(description = "Модель регистрации замдекана")
data class RegisterRequest(
    @NotBlank(message = "У замдекана не может не быть имени")
    @JsonProperty("first_name")
    @Schema(description = "Имя замдекана")
    val firstName: String,
    @NotBlank(message = "У замдекана не может не быть фамилии")
    @JsonProperty("last_name")
    @Schema(description = "Фамилия замдекана")
    val lastName: String,
    @NotBlank(message = "У замдекана не может не быть отчества")
    @JsonProperty("patronymic")
    @Schema(description = "Отчество замдекана")
    val patronymic: String,
    @NotBlank(message = "У замдекана не может не быть email")
    @JsonProperty("email")
    @Schema(description = "E-mail адрес замдекана")
    val email: String,
    @NotBlank(message = "Замдекана не может зарегистрироваться без пароля")
    @JsonProperty("password")
    @Schema(description = "Пароль замдекана")
    val password: String
)