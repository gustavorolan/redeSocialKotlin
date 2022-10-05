package com.api.socialNetwork.service.verifier.impl

import com.api.socialNetwork.service.verifier.Verifier
import com.api.socialNetwork.service.verifier.VerifierExecutor
import org.springframework.stereotype.Service

@Service
class VerifierExecutorImpl : VerifierExecutor {
    override fun verify(verificationList: List<Verifier>, request: Any) {
        verificationList.forEach { verifier ->
            verifier.verify(request)
        }
    }
}