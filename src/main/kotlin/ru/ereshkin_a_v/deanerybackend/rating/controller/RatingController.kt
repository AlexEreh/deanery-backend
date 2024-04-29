package ru.ereshkin_a_v.deanerybackend.rating.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.ereshkin_a_v.deanerybackend.rating.responses.RatingListDTO
import ru.ereshkin_a_v.deanerybackend.rating.service.RatingService

@RestController
@RequestMapping("/rating")
@Tag(name = "Rating Controller", description = "API для операций над рейтинговыми списками")
class RatingController(
    private val service: RatingService
) {

    @GetMapping("/get")
    fun getAllRatingLists(
        @RequestParam(required=true) course: Int,
        @RequestParam(required=true) year: Int,
        @RequestParam(required=true) semester: Int
    ): MutableSet<RatingListDTO> {
        return service.getAllLists(course, year, semester)
    }
}