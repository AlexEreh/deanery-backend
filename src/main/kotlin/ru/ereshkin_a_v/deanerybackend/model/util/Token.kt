package ru.ereshkin_a_v.deanerybackend.model.util

import jakarta.persistence.*
import ru.ereshkin_a_v.deanerybackend.deputydean.entities.DeputyDean

@Entity
class Token(
    @Column(unique = true, nullable = false)
    val token: String? = null,
    @Enumerated(EnumType.STRING)
    val tokenType: TokenType = TokenType.BEARER,
    var revoked: Boolean = false,
    var expired: Boolean = false,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    var deputyDean: DeputyDean? = null
): BaseEntity()