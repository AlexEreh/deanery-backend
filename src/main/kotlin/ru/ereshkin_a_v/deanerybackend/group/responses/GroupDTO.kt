package ru.ereshkin_a_v.deanerybackend.group.responses

import com.fasterxml.jackson.annotation.JsonProperty
import ru.ereshkin_a_v.deanerybackend.group.entities.StudentGroup

data class GroupDTO(
    @JsonProperty("id")
    val id: Long,
    @JsonProperty("specialty")
    val specialty: String,
    @JsonProperty("course")
    val course: Int,
    @JsonProperty("number")
    val number: Int
)

fun StudentGroup.asDTO(): GroupDTO {
    return GroupDTO(
        id = id!!,
        specialty = specialty!!,
        course = course!!,
        number = number!!
    )
}