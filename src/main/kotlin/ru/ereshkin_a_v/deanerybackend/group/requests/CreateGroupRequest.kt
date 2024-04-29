package ru.ereshkin_a_v.deanerybackend.group.requests

data class CreateGroupRequest(
    val course: Int,
    val number: Int,
    val specialty: String
)