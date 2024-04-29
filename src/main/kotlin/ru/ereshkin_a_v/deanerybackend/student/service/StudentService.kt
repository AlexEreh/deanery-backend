package ru.ereshkin_a_v.deanerybackend.student.service

import io.swagger.v3.oas.annotations.Operation
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import ru.ereshkin_a_v.deanerybackend.exceptions.ResourceNotFoundException
import ru.ereshkin_a_v.deanerybackend.group.repository.GroupRepository
import ru.ereshkin_a_v.deanerybackend.group.responses.asDTO
import ru.ereshkin_a_v.deanerybackend.student.entities.Student
import ru.ereshkin_a_v.deanerybackend.student.repository.StudentRepository
import ru.ereshkin_a_v.deanerybackend.student.requests.CreateStudentDTO
import ru.ereshkin_a_v.deanerybackend.student.responses.CreateStudentResponse
import ru.ereshkin_a_v.deanerybackend.student.responses.StudentDTO

@Service
class StudentService(
    private val studentRepository: StudentRepository,
    private val groupRepository: GroupRepository
) {
    fun createStudent(request: CreateStudentDTO): CreateStudentResponse {
        val student = studentRepository.findByFirstNameAndLastNameAndPatronymicAndGroup_Id(
            firstName = request.firstName,
            lastName = request.lastName,
            patronymic = request.patronymic,
            id = request.groupId
        )
        if (student != null) {
            return CreateStudentResponse(student.id!!)
        }
        val group = groupRepository.findStudentGroupById(request.groupId)
            ?: throw ResourceNotFoundException("Не удалось найти группу, связанную со студентом")
        val newStudent = Student(
            firstName = request.firstName,
            lastName = request.lastName,
            patronymic = request.lastName,
            group = group
        )
        studentRepository.save(newStudent)
        val newStudentFromDB = studentRepository.findByFirstNameAndLastNameAndPatronymicAndGroup_Id(
            firstName = request.firstName,
            lastName = request.lastName,
            patronymic = request.patronymic,
            id = request.groupId
        )
        return CreateStudentResponse(newStudentFromDB!!.id!!)
    }
    fun getStudentById(id: Long): StudentDTO {
        val studentFromRepo = studentRepository.getStudentById(id)
            ?: throw ResourceNotFoundException("Студент не найден!")
        return with(studentFromRepo) {
            StudentDTO(
                id = id,
                firstName = firstName!!,
                lastName = lastName!!,
                patronymic = patronymic!!,
                group = group!!.asDTO(),
            )
        }
    }


    fun removeStudent(id: Long) {
        studentRepository.deleteStudentById(id)
    }
}