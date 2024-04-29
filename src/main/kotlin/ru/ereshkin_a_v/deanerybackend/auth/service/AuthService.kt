package ru.ereshkin_a_v.deanerybackend.auth.service

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.ereshkin_a_v.deanerybackend.auth.requests.LoginRequest
import ru.ereshkin_a_v.deanerybackend.auth.requests.RegisterRequest
import ru.ereshkin_a_v.deanerybackend.auth.responses.AuthResponse
import ru.ereshkin_a_v.deanerybackend.auth.token.TokenRepository
import ru.ereshkin_a_v.deanerybackend.auth.util.JwtService
import ru.ereshkin_a_v.deanerybackend.deputydean.entities.DeputyDean
import ru.ereshkin_a_v.deanerybackend.model.util.Role
import ru.ereshkin_a_v.deanerybackend.model.util.Token
import ru.ereshkin_a_v.deanerybackend.model.util.TokenType
import ru.ereshkin_a_v.deanerybackend.deputydean.repository.DeputyDeanRepository
import java.io.IOException

@Service
class AuthService(
    private val repository: DeputyDeanRepository,
    private val tokenRepository: TokenRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager
) {
    fun login(request: LoginRequest): AuthResponse {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.email,
                request.password
            )
        )
        val user = repository.findDeputyDeanByEmail(request.email) ?: throw Exception("Пользователь не найден.")
        val jwtToken = jwtService.generateToken(user)
        val refreshToken = jwtService.generateRefreshToken(user)
        revokeAllUserTokens(user)
        saveUserToken(user, jwtToken)
        return AuthResponse(accessToken = jwtToken, refreshToken = refreshToken)
    }
    fun register(request: RegisterRequest): AuthResponse {
        val deputyDean = DeputyDean(
            firstName = request.firstName,
            lastName = request.lastName,
            patronymic = request.patronymic,
            email = request.email,
            hashedPassword = passwordEncoder.encode(request.password),
            role = Role.USER,

        )

        val savedUser = repository.save(deputyDean)
        val jwtToken = jwtService.generateToken(deputyDean)
        val refreshToken = jwtService.generateRefreshToken(deputyDean)
        saveUserToken(savedUser, jwtToken)
        return AuthResponse(accessToken = jwtToken, refreshToken = refreshToken)
    }

    private fun saveUserToken(deputyDean: DeputyDean, jwtToken: String) {
        val token = Token(
            deputyDean = deputyDean,
            token = jwtToken,
            tokenType = TokenType.BEARER,
            expired = false,
            revoked = false
        )
        tokenRepository.save(token)
    }

    private fun revokeAllUserTokens(deputyDean: DeputyDean) {
        val validUserTokens = tokenRepository.findAllValidTokenByDeputyDean(deputyDean.id!!)
        if (validUserTokens.isEmpty()) return
        validUserTokens.forEach { token ->
            token.expired = true
            token.revoked = true
        }
        tokenRepository.saveAll(validUserTokens)
    }

    @Throws(IOException::class)
    fun refreshToken(
        request: HttpServletRequest,
        response: HttpServletResponse
    ) {
        val authHeader = request.getHeader(HttpHeaders.AUTHORIZATION)
        val userEmail: String
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return
        }
        val refreshToken = authHeader.substring(7)
        userEmail = jwtService.extractUsername(refreshToken)
        val user = repository.findDeputyDeanByEmail(userEmail) ?: throw IOException()
        if (jwtService.isTokenValid(refreshToken, user)) {
            val accessToken = jwtService.generateToken(user)
            revokeAllUserTokens(user)
            saveUserToken(user, accessToken)
            val authResponse = AuthResponse(
                accessToken = accessToken,
                refreshToken = refreshToken
            )
            ObjectMapper().writeValue(response.outputStream, authResponse)
        }
    }

}