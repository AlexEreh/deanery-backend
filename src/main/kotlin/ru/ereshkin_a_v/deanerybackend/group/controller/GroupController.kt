package ru.ereshkin_a_v.deanerybackend.group.controller

import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.*
import ru.ereshkin_a_v.deanerybackend.group.requests.CreateGroupRequest
import ru.ereshkin_a_v.deanerybackend.group.responses.CreateGroupResponse
import ru.ereshkin_a_v.deanerybackend.group.responses.GroupDTO
import ru.ereshkin_a_v.deanerybackend.group.service.GroupService

@RestController
@RequestMapping("/groups")
@Tag(name = "Group Controller", description = "API для операций над группами")
class GroupController(
    private val service: GroupService
) {
    @PostMapping("/create")
    fun createGroup(
        @RequestBody request: CreateGroupRequest
    ): CreateGroupResponse {
        return service.createGroup(request)
    }

    @GetMapping("/get/{id}")
    fun getGroup(
        @PathVariable("id") id: Long
    ): GroupDTO {
        return service.getGroup(id)
    }
}