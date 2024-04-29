package ru.ereshkin_a_v.deanerybackend.gradesheet.requests

import io.swagger.v3.oas.annotations.Parameter

data class GradeSheetDTO(
    @Parameter(name = "Элементы списка ведомости")
    val elements: MutableSet<GradeSheetElementDTO>,
    @Parameter(name = "Дисциплина")
    val discipline: String,
    @Parameter(name = "Этап")
    val stage: String,
    @Parameter(name = "Семестр")
    val semester: Int,
    @Parameter(name = "Год")
    val year: Int,
    @Parameter(name = "Курс")
    val course: Int
)
