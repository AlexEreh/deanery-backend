package ru.ereshkin_a_v.deanerybackend.rating.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.ereshkin_a_v.deanerybackend.rating.entities.RatingListElement

@Repository
interface RatingListElementRepository : JpaRepository<RatingListElement, Long> {
    fun findAllByRatingListId(id: Long): MutableSet<RatingListElement>
}