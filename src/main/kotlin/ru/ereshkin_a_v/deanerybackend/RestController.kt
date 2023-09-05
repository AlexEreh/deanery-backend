package ru.ereshkin_a_v.deanerybackend

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class RestController(
    private val groupRepository: GroupRepository
) {
    @GetMapping("/groups")
    fun findAll() = groupRepository.getAllBy()
}