package ru.ereshkin_a_v.deanerybackend.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToMany

@Entity
open class Group(
    @Id @GeneratedValue val id: Long? = null,
    @Column(name = "COURSE") val course: Int,
    @OneToMany(orphanRemoval = true) @JoinColumn(name = "GROUP_ID")
    val students: Set<Student>
)
