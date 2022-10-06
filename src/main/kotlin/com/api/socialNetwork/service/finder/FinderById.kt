package com.api.socialNetwork.service.finder

interface FinderById {
    fun findByIdWithException(id: Long):Any
}
