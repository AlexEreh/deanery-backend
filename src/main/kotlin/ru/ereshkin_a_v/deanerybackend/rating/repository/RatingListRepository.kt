package ru.ereshkin_a_v.deanerybackend.rating.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.ereshkin_a_v.deanerybackend.rating.entities.RatingList

@Repository
interface RatingListRepository : JpaRepository<RatingList, Long> {
    fun findByCourseAndYearAndSemester(
        course: Int,
        year: Int,
        semester: Int
    ): MutableSet<RatingList>
}