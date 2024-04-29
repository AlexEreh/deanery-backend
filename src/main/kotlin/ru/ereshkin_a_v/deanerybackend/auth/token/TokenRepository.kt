package ru.ereshkin_a_v.deanerybackend.auth.token

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.ereshkin_a_v.deanerybackend.model.util.Token

@Repository
interface TokenRepository : JpaRepository<Token, Long> {
    @Query(
        value = """select t from Token t inner join DeputyDean u on t.deputyDean.id = u.id where u.id = :id and (t.expired = false or t.revoked = false)"""
    )
    fun findAllValidTokenByDeputyDean(id: Long): MutableSet<Token>

    fun findTokenByToken(token: String): Token?
}