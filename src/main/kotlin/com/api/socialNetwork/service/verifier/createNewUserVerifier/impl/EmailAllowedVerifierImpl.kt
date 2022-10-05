package com.api.socialNetwork.service.verifier.createNewUserVerifier.impl

import com.api.socialNetwork.dtos.request.CreateNewUserRequest
import com.api.socialNetwork.exception.NotAllowedEmailException
import com.api.socialNetwork.service.verifier.createNewUserVerifier.CreateNewUserVerifier
import java.util.regex.Pattern

class EmailAllowedVerifierImpl : CreateNewUserVerifier {
    override fun verify(request: Any) {
        val requestMap: CreateNewUserRequest = request as CreateNewUserRequest
        val patternEmail = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE
        )
        val matcher = patternEmail.matcher(requestMap.email)
        if (!matcher.find()) {
            throw NotAllowedEmailException()
        }
    }
}