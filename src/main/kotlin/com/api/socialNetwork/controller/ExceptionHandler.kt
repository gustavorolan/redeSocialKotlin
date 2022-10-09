package com.api.socialNetwork.controller

import com.api.socialNetwork.exception.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(
        FriendshipNotFoundedException::class,
        UserAccountNotFoundedException::class
    )
    fun notFoundedHandler(exception: RuntimeException): ResponseEntity<String> {
        return ResponseEntity<String>(exception.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(
        EmailNotAllowedException::class,
        AddingItselfException::class,
        UserLoggedCanAcceptFriendshipException::class
    )
    fun badRequestHandler(exception: RuntimeException): ResponseEntity<String> {
        return ResponseEntity<String>(exception.message, HttpStatus.BAD_REQUEST)
    }
}