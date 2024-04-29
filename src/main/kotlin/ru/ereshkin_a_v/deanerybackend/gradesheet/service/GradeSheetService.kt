package ru.ereshkin_a_v.deanerybackend.gradesheet.service

import org.springframework.stereotype.Service
import ru.ereshkin_a_v.deanerybackend.exceptions.ResourceNotFoundException
import ru.ereshkin_a_v.deanerybackend.gradesheet.repository.AcademicListRepository
import ru.ereshkin_a_v.deanerybackend.gradesheet.requests.GradeSheetDTO
import ru.ereshkin_a_v.deanerybackend.academiclist.entities.AcademicList
import ru.ereshkin_a_v.deanerybackend.academiclist.entities.AcademicListElement
import ru.ereshkin_a_v.deanerybackend.model.RatingStage

@Service
class GradeSheetService(
    private val academicListRepository: AcademicListRepository
) {
    fun submitGradeSheet(body: GradeSheetDTO) {
        val stage = when(body.stage) {
            "FIRST_ATT" -> RatingStage.FIRST_ATT
            "SECOND_ATT" -> RatingStage.SECOND_ATT
            "THIRD_ATT" -> RatingStage.THIRD_ATT
            "EXAM" -> RatingStage.EXAM
            else -> {
                throw ResourceNotFoundException("Нет такого этапа!")
            }
        }
        val academicList = AcademicList(
            elements = body.elements.map {
                AcademicListElement()
            }.toMutableSet(),
            discipline = body.discipline
        )
    }
}