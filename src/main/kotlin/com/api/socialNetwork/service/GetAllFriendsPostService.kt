package com.api.socialNetwork.service

interface GetAllFriendsPostService {
    fun get(page: Int): List<Long>
}
