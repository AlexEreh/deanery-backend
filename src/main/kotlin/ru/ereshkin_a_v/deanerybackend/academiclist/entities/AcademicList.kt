package ru.ereshkin_a_v.deanerybackend.academiclist.entities

import jakarta.persistence.*
import ru.ereshkin_a_v.deanerybackend.model.util.BaseEntity

@Entity
class AcademicList (
    @OneToMany(
        mappedBy = "academicList",
        cascade = [CascadeType.ALL],
        fetch = FetchType.LAZY
    )
    val elements: MutableSet<AcademicListElement> = mutableSetOf(),
    @Column(nullable = false)
    val discipline: String? = null,
): BaseEntity()