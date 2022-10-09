package com.api.socialNetwork.utils.factory

import com.api.socialNetwork.controller.dtos.request.AcceptFriendshipRequest
import com.api.socialNetwork.controller.dtos.request.RequestFriendshipRequest
import com.api.socialNetwork.model.Friendship
import com.api.socialNetwork.model.Relation
import com.api.socialNetwork.model.UserAccount


class FriendshipFactory {
    companion object {
        fun getFriendShip(userAccount: UserAccount, friend:UserAccount): Friendship =
            Friendship(
                userAccount = userAccount,
                 userFriendShip = friend,
                relation = Relation.NOT_FRIENDS
            )

        fun getFriendShipRequest(): RequestFriendshipRequest =
            RequestFriendshipRequest(
               friendId = 1L
            )

        fun getAcceptFriendShipRequest(id:Long): AcceptFriendshipRequest =
            AcceptFriendshipRequest(
                friendId = id
            )

    }
}