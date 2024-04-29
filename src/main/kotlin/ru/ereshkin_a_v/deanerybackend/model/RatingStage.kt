package ru.ereshkin_a_v.deanerybackend.model

enum class RatingStage(
    val representation: String
){
    FIRST_ATT("1 аттестация"),
    SECOND_ATT("2 аттестация"),
    THIRD_ATT("3 аттестация"),
    EXAM("Экзамен")
}