package ru.ereshkin_a_v.deanerybackend.student.responses

import com.fasterxml.jackson.annotation.JsonProperty
import ru.ereshkin_a_v.deanerybackend.group.responses.GroupDTO

data class StudentDTO(
    @JsonProperty("id")
    var id: Long,
    @JsonProperty("first_name")
    var firstName: String,
    @JsonProperty("last_name")
    var lastName: String,
    @JsonProperty("patronymic")
    var patronymic: String,
    var group: GroupDTO
)
