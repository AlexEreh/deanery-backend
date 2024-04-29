package ru.ereshkin_a_v.deanerybackend.rating.responses

import com.fasterxml.jackson.annotation.JsonProperty

data class RatingCreatedResponseDTO (
    @JsonProperty("rating_id")
    val ratingId: Long
)