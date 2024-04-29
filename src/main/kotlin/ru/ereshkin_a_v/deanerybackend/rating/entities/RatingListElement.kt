package ru.ereshkin_a_v.deanerybackend.rating.entities

import jakarta.persistence.*
import ru.ereshkin_a_v.deanerybackend.model.util.BaseEntity
import ru.ereshkin_a_v.deanerybackend.student.entities.Student

@Entity
class RatingListElement(
    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "rating_list_id")
    var ratingList: RatingList? = null,
    @ManyToOne
    @JoinColumn(name = "student_id")
    var student: Student? = null,
    @Column(name = "score")
    var score: Int? = null
): BaseEntity()