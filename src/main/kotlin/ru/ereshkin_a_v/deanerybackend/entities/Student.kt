package ru.ereshkin_a_v.deanerybackend.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
open class Student(
    @Id @GeneratedValue
    @Column(name = "id") val id: Long,
    @Column(name = "first_name") val firstName: String,
    @Column(name = "last_name") val lastName: String,
    @Column(name = "patronymic") val patronymic: String,
)
