package ru.ereshkin_a_v.deanerybackend.student.entities

import jakarta.persistence.*
import ru.ereshkin_a_v.deanerybackend.group.entities.StudentGroup
import ru.ereshkin_a_v.deanerybackend.model.util.BaseEntity

@Entity
class Student(
    @Column(nullable = false)
    val firstName: String? = null,
    @Column(nullable = false)
    val lastName: String? = null,
    @Column(nullable = false)
    val patronymic: String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id", nullable = false)
    val group: StudentGroup? = null,
): BaseEntity()