package com.api.socialNetwork.service.finder

import com.api.socialNetwork.model.UserAccount

interface UserAccountFinder{
    fun findByIdWithException(id:Long): UserAccount
}
