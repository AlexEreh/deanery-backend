package ru.ereshkin_a_v.deanerybackend.student.requests

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateStudentDTO(
    @JsonProperty("group_id")
    val groupId: Long,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String,
    @JsonProperty("patronymic")
    val patronymic: String
)
