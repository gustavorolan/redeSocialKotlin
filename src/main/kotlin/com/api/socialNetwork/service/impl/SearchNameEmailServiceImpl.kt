package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.SearchNameEmailRequest
import com.api.socialNetwork.controller.dtos.response.UserAccountResponse
import com.api.socialNetwork.mapper.UserResponseMapper
import com.api.socialNetwork.model.Environment
import com.api.socialNetwork.model.Relation
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.repository.UserAccountRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.SearchNameEmailService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service


@Service
class SearchNameEmailServiceImpl(
    private var userAccountRepository: UserAccountRepository,
    private val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val friendshipRepository: FriendshipRepository,
    private val userResponseMapper: UserResponseMapper,
) : SearchNameEmailService {

    override fun search(request: SearchNameEmailRequest): Page<UserAccountResponse> {
        val pageable: Pageable = PageRequest.of(request.page,Environment.PAGEABLE.numberOfContents)

        val user: UserAccount = findUserAuthenticatedService.user

        val friendshipsFromUser = friendshipRepository
            .filterFriendsByUser(user.userId!!, Relation.FRIENDS);

        val friendsIdsFromUser = mutableListOf<Long>()

        friendshipsFromUser.forEach { friendship ->
            if(!friendsIdsFromUser.contains(friendship.userFriendShip.userId))
                friendsIdsFromUser.add(friendship.userFriendShip.userId!!)
            if(!friendsIdsFromUser.contains(friendship.userAccount.userId))
                friendsIdsFromUser.add(friendship.userAccount.userId!!)
        }

        val filterAllPeopleEmailName = userAccountRepository
            .filterAllPeopleEmailName(request.search!!, friendsIdsFromUser,pageable)

        return filterAllPeopleEmailName.map { userResponseMapper.toResponse(it) }
    }
}