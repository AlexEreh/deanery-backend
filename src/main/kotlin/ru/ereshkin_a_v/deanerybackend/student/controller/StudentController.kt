package ru.ereshkin_a_v.deanerybackend.student.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import ru.ereshkin_a_v.deanerybackend.student.requests.CreateStudentDTO
import ru.ereshkin_a_v.deanerybackend.student.responses.CreateStudentResponse
import ru.ereshkin_a_v.deanerybackend.student.responses.StudentDTO
import ru.ereshkin_a_v.deanerybackend.student.service.StudentService

@RestController
@RequestMapping("/student")
@Tag(name = "Student Controller", description = "API для операций над студентами")
class StudentController(
    private val studentService: StudentService
) {
    @PostMapping("/create")
    @Operation(
        method = "POST",
        summary = "Добавить нового студента в базу данных"
    )
    fun createStudent(
        @RequestBody request: CreateStudentDTO
    ): CreateStudentResponse {
        return studentService.createStudent(request)
    }

    @GetMapping("/get")
    @Operation(
        method = "GET",
        summary = "Получить студента по его id"
    )
    fun getStudentById(
        id: Long
    ): StudentDTO {
        return studentService.getStudentById(id)
    }

    @DeleteMapping("/delete")
    @Operation(
        method = "DELETE",
        summary = "Удалить студента из базы по ID"
    )
    fun deleteStudent(
        id: Long
    ) {
        return studentService.removeStudent(id)
    }
}