package ru.ereshkin_a_v.deanerybackend.gradesheet.controller

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.ereshkin_a_v.deanerybackend.gradesheet.requests.GradeSheetDTO
import ru.ereshkin_a_v.deanerybackend.gradesheet.service.GradeSheetService

@RestController
class GradeSheetController(
    private val service: GradeSheetService
) {
    fun submitGradeSheet(
        @RequestBody body: GradeSheetDTO
    ) {
        service.submitGradeSheet(body)
    }
}