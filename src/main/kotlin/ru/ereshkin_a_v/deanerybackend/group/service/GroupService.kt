package ru.ereshkin_a_v.deanerybackend.group.service

import org.springframework.stereotype.Service
import ru.ereshkin_a_v.deanerybackend.exceptions.ResourceNotFoundException
import ru.ereshkin_a_v.deanerybackend.group.repository.GroupRepository
import ru.ereshkin_a_v.deanerybackend.group.requests.CreateGroupRequest
import ru.ereshkin_a_v.deanerybackend.group.responses.CreateGroupResponse
import ru.ereshkin_a_v.deanerybackend.group.responses.GroupDTO
import ru.ereshkin_a_v.deanerybackend.group.entities.StudentGroup

@Service
class GroupService(
    private val repository: GroupRepository
) {
    fun createGroup(request: CreateGroupRequest): CreateGroupResponse {
        val group = repository.getByCourseAndNumberAndSpecialty(
            course = request.course,
            number = request.number,
            specialty = request.specialty
        )
        if (group != null) {
            return CreateGroupResponse(group.id!!)
        }
        val newGroup = StudentGroup(
            specialty = request.specialty,
            course = request.course,
            number = request.number
        )
        repository.save(newGroup)
        val createdGroup = repository.getByCourseAndNumberAndSpecialty(
            course = request.course,
            number = request.number,
            specialty = request.specialty
        )
        return CreateGroupResponse(
            createdGroup!!.id!!
        )
    }

    fun getGroup(id: Long): GroupDTO {
        val groupFromRepo: StudentGroup
        try {
            groupFromRepo = repository.getReferenceById(id)
        } catch (e: Exception) {
            throw ResourceNotFoundException("Группа не найдена!")
        }
        val dto = GroupDTO(
            id = groupFromRepo.id!!,
            specialty = groupFromRepo.specialty!!,
            course = groupFromRepo.course!!,
            number = groupFromRepo.number!!
        )
        return dto
    }
}