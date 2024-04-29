package ru.ereshkin_a_v.deanerybackend.gradesheet.requests

import io.swagger.v3.oas.annotations.Parameter

data class GradeSheetElementDTO(
    @Parameter(name = "Имя студента")
    val firstName: String,
    @Parameter(name = "Фамилия студента")
    val lastName: String,
    @Parameter(name = "Отчество студента")
    val patronymic: String,
    @Parameter(name = "Оценка студента")
    val score: String
)
