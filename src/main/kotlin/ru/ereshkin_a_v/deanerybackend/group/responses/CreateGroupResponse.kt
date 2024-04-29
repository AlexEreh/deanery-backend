package ru.ereshkin_a_v.deanerybackend.group.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class CreateGroupResponse (
    @JsonProperty("id")
    val id: Long
)