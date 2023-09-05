package ru.ereshkin_a_v.deanerybackend

import org.springframework.data.repository.CrudRepository
import ru.ereshkin_a_v.deanerybackend.entities.Group

interface GroupRepository: CrudRepository<Group, Long> {
    fun getAllBy(): List<Group>
}