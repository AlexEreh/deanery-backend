package ru.ereshkin_a_v.deanerybackend.rating.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class RatingListElementDTO (
    @JsonProperty("score")
    val score: Int,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String,
    @JsonProperty("patronymic")
    val patronymic: String,
    @JsonProperty("student_id")
    val studentId: Long,
    @JsonProperty("id")
    val id: Long
)