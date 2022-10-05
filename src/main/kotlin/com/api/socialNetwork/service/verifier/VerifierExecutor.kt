package com.api.socialNetwork.service.verifier

interface VerifierExecutor {
    fun verify(verificationList: List<Verifier>, request:Any)
}