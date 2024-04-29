package ru.ereshkin_a_v.deanerybackend.group.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany
import ru.ereshkin_a_v.deanerybackend.model.util.BaseEntity
import ru.ereshkin_a_v.deanerybackend.student.entities.Student

@Entity
class StudentGroup(
    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "group"
    )
    val students: MutableSet<Student> = mutableSetOf(),
    @Column(nullable = false)
    val specialty: String? = null,
    @Column(nullable = false)
    val course: Int? = null,
    @Column(nullable = false)
    val number: Int? = null
): BaseEntity()