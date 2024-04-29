package ru.ereshkin_a_v.deanerybackend.gradesheet.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ereshkin_a_v.deanerybackend.academiclist.entities.AcademicListElement

interface AcademicListElementRepository : JpaRepository<AcademicListElement, Long> {
    //fun
}