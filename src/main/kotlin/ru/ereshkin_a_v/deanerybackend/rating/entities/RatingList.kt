package ru.ereshkin_a_v.deanerybackend.rating.entities

import jakarta.persistence.*
import ru.ereshkin_a_v.deanerybackend.model.RatingStage
import ru.ereshkin_a_v.deanerybackend.model.util.BaseEntity
import java.time.LocalDateTime

@Entity
class RatingList(
    @Column(name = "created_at")
    var createdAt: LocalDateTime? = null,
    @Column(name = "course")
    var course: Int? = null,
    @Column(name = "year")
    var year: Int? = null,
    @Column(name = "semester")
    var semester: Int? = null,
    @OneToMany(
        mappedBy = "ratingList",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var elements: MutableSet<RatingListElement> = mutableSetOf(),
    @Column(name = "stage")
    @Enumerated(EnumType.STRING)
    var stage: RatingStage? = null
): BaseEntity() {

}