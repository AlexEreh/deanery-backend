package ru.ereshkin_a_v.deanerybackend.rating.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class RatingListDTO(
    @JsonProperty("data")
    val elements: MutableSet<RatingListElementDTO>,
    @JsonProperty("semester")
    val semester: Int,
    @JsonProperty("course")
    val course: Int,
    @JsonProperty("year")
    val year: Int,
    @JsonProperty("stage")
    val stage: String,
    val id: Long
)
