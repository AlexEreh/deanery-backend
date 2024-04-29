package ru.ereshkin_a_v.deanerybackend.academiclist.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import ru.ereshkin_a_v.deanerybackend.model.util.BaseEntity
import ru.ereshkin_a_v.deanerybackend.student.entities.Student

@Entity
class AcademicListElement (
    @ManyToOne
    @JoinColumn(name = "academic_list_id")
    val academicList: AcademicList? = null,
    @Column(nullable = true)
    val firstAttestationScore: Int? = null,
    @Column(nullable = true)
    val secondAttestationScore: Int? = null,
    @Column(nullable = true)
    val thirdAttestationScore: Int? = null,
    @Column(nullable = true)
    val examScore: Int? = null,
    @ManyToOne
    @JoinColumn(name = "student_id")
    val student: Student? = null
): BaseEntity()