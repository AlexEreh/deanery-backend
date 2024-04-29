package ru.ereshkin_a_v.deanerybackend.rating.service

import org.springframework.stereotype.Service
import ru.ereshkin_a_v.deanerybackend.exceptions.ResourceNotFoundException
import ru.ereshkin_a_v.deanerybackend.rating.entities.RatingList
import ru.ereshkin_a_v.deanerybackend.rating.repository.RatingListElementRepository
import ru.ereshkin_a_v.deanerybackend.rating.repository.RatingListRepository
import ru.ereshkin_a_v.deanerybackend.rating.responses.RatingCreatedResponseDTO
import ru.ereshkin_a_v.deanerybackend.rating.responses.RatingListDTO
import ru.ereshkin_a_v.deanerybackend.rating.responses.RatingListElementDTO

@Service
class RatingService(
    private val ratingListRepository: RatingListRepository,
    private val ratingListElementRepository: RatingListElementRepository
) {
    fun makeRatingList(course: Int, year: Int, semester: Int): RatingCreatedResponseDTO {
        return RatingCreatedResponseDTO(0)
    }

    fun getAllLists(course: Int, year: Int, semester: Int): MutableSet<RatingListDTO> {
        return ratingListRepository.findByCourseAndYearAndSemester(course, year, semester).map { list ->
            RatingListDTO(
                elements = list.elements.map {
                    RatingListElementDTO(
                        id = it.id!!,
                        score = it.score!!,
                        studentId = it.student!!.id!!,
                        firstName = it.student!!.firstName!!,
                        lastName = it.student!!.lastName!!,
                        patronymic = it.student!!.patronymic!!
                    )
                }.toMutableSet(),
                stage = list.stage!!.representation,
                semester = list.semester!!,
                course = list.course!!,
                year = list.year!!,
                id = list.id!!
            )
        }.toMutableSet()
    }

    fun getListById(id: Long): RatingListDTO {
        val lol: RatingList
        try {
            lol = ratingListRepository.getReferenceById(id)
        } catch (e: Exception) {
            throw ResourceNotFoundException("Рейтинговый список по данному ID не был найден")
        }
        val ratingListElements = ratingListElementRepository
            .findAllByRatingListId(lol.id!!)
            .map {
                RatingListElementDTO(
                    id = it.id!!,
                    score = it.score!!,
                    studentId = it.student!!.id!!,
                    firstName = it.student!!.firstName!!,
                    lastName = it.student!!.lastName!!,
                    patronymic = it.student!!.patronymic!!
                )
            }
            .toMutableSet()
        return RatingListDTO(
            stage = lol.stage!!.representation,
            semester = lol.semester!!,
            course = lol.course!!,
            year = lol.year!!,
            id = lol.id!!,
            elements = ratingListElements
        )
    }

    fun deleteList(id: Long) {

    }
}