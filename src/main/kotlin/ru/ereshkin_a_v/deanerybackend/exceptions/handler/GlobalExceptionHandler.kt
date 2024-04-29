package ru.ereshkin_a_v.deanerybackend.exceptions.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import ru.ereshkin_a_v.deanerybackend.exceptions.ResourceNotFoundException

@ControllerAdvice
class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
    @ExceptionHandler
    fun catchResourceNotFoundException(e: ResourceNotFoundException): ResponseEntity<AppError> {
        return ResponseEntity(
            AppError(
                statusCode = HttpStatus.NOT_FOUND.value(),
                message = "Ресурс не был найден на сервере",
                debugMessage = e.message!!
            ),
            HttpStatus.NOT_FOUND
        )
    }
}