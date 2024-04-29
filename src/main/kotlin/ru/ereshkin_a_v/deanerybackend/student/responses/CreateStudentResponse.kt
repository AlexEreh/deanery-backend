package ru.ereshkin_a_v.deanerybackend.student.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateStudentResponse(
    @JsonProperty("id")
    val id: Long
)
