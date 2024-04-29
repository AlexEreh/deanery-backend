package ru.ereshkin_a_v.deanerybackend.model.util

import org.springframework.security.core.authority.SimpleGrantedAuthority

enum class Role(
    private val permissions: Set<Permission>
) {
    USER(emptySet());

    val authorities: MutableSet<SimpleGrantedAuthority>
        get() {
            val authorities = permissions
                .map { permission -> SimpleGrantedAuthority(permission.permission) }
                .toMutableSet()
            authorities.add(SimpleGrantedAuthority("ROLE_" + this.name))
            return authorities
        }
}