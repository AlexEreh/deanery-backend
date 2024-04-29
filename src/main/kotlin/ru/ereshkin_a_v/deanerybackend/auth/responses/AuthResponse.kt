package ru.ereshkin_a_v.deanerybackend.auth.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthResponse(
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("refresh_token")
    val refreshToken: String,
)
