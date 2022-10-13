package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.mapper.UserResponseMapper
import com.api.socialNetwork.model.Relation
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.GetAllRequestFriendsService
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class GetAllRequestFriendsServiceImpl(
    private val userAuthenticatedService: FindUserAuthenticatedService,
    private val userResponseMapper: UserResponseMapper,
    private val friendshipRepository: FriendshipRepository
) : GetAllRequestFriendsService {
    override fun get(): List<UserAccountResponse> {
        val user = userAuthenticatedService.user
        val peopleNotFriend = friendshipRepository.filterFriendsByUser(user.userId!!, Relation.NOT_FRIENDS)
        val requestUserAccountsStream  = peopleNotFriend.stream().map { person -> person.userAccount }
        val userAccountsWithoutUser = requestUserAccountsStream.filter { userAccount -> userAccount != user }
        val userAccountsRequestResponse = userAccountsWithoutUser.map { requestUser -> userResponseMapper.toResponse(requestUser) }
        return userAccountsRequestResponse.collect(Collectors.toList())
    }
}