package com.api.socialNetwork.service

import com.api.socialNetwork.model.UserAccount

interface GetFriendsService {
    fun get():List<UserAccount>
}