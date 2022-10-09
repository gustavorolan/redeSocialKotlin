package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.AcceptFriendshipRequest
import com.api.socialNetwork.model.Relation
import com.api.socialNetwork.model.UserAccount
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.AcceptFriendshipService
import com.api.socialNetwork.service.finder.impl.UserAccountFinderByIdImpl
import com.api.socialNetwork.service.validator.UserLoggedCanAcceptFriendshipValidation
import org.springframework.stereotype.Service

@Service
class AcceptFriendshipServiceImpl(
    private  val findUserAuthenticatedService: FindUserAuthenticatedService,
    private val userAccountFinderByIdImpl: UserAccountFinderByIdImpl,
    private val friendshipRepository: FriendshipRepository,
    private val userLoggedCanAcceptFriendshipValidation: UserLoggedCanAcceptFriendshipValidation
): AcceptFriendshipService {
    override fun accept(request: AcceptFriendshipRequest) {
        val user = findUserAuthenticatedService.user
        val userToAdd = userAccountFinderByIdImpl.findByIdWithException(request.friendId) as UserAccount
        val friendship = friendshipRepository.findFirstFriendshipByUsersIdList(user.userId!!, userToAdd.userId!!)

        userLoggedCanAcceptFriendshipValidation.validate(friendship)

        friendship.relation = Relation.FRIENDS

        friendshipRepository.save(friendship)
    }
}