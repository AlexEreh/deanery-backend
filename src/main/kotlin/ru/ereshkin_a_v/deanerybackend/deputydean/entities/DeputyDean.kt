package ru.ereshkin_a_v.deanerybackend.deputydean.entities

import jakarta.persistence.*
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import ru.ereshkin_a_v.deanerybackend.model.util.BaseEntity
import ru.ereshkin_a_v.deanerybackend.model.util.Role
import ru.ereshkin_a_v.deanerybackend.model.util.Token

@Entity
@Table(name = "deputy_dean")
class DeputyDean(
    @Column(nullable = false, name = "first_name")
    var firstName: String? = null,
    @Column(nullable = false, name = "last_name")
    var lastName: String? = null,
    @Column(nullable = false, name = "patronymic")
    var patronymic: String? = null,
    @Column(nullable = false)
    var email: String? = null,
    @Column(nullable = false)
    var hashedPassword: String? = null,
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var role: Role? = null,
    @OneToMany(mappedBy = "deputyDean")
    val tokens: MutableSet<Token> = mutableSetOf()
) : BaseEntity(), UserDetails {


    override fun getAuthorities(): MutableSet<SimpleGrantedAuthority> {
        return role!!.authorities
    }

    override fun getPassword(): String {
        return hashedPassword!!
    }

    override fun getUsername(): String {
        return email!!
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

}