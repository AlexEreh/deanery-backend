package ru.ereshkin_a_v.deanerybackend.student.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ereshkin_a_v.deanerybackend.student.entities.Student

interface StudentRepository : JpaRepository<Student, Long> {
    fun getStudentById(id: Long): Student?


    fun findByFirstNameAndLastNameAndPatronymicAndGroup_Id(
        firstName: String,
        lastName: String,
        patronymic: String,
        id: Long
    ): Student?

    fun deleteStudentById(id: Long)
}