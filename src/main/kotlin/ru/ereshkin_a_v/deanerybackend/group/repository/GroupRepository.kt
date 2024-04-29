package ru.ereshkin_a_v.deanerybackend.group.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ereshkin_a_v.deanerybackend.group.entities.StudentGroup

interface GroupRepository: JpaRepository<StudentGroup, Long> {
    fun getByCourseAndNumberAndSpecialty(course: Int, number: Int, specialty: String): StudentGroup?
    fun getByCourseAndNumber(course: Int, number: Int): StudentGroup?
    fun findStudentGroupById(id: Long): StudentGroup?
}