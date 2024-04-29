package ru.ereshkin_a_v.deanerybackend.deputydean.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.ereshkin_a_v.deanerybackend.deputydean.entities.DeputyDean

interface DeputyDeanRepository : JpaRepository<DeputyDean, Long> {
    fun findDeputyDeanByEmail(email: String): DeputyDean?
}