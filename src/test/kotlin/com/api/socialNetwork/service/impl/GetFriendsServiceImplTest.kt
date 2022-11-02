package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.Relation
import com.api.socialNetwork.repository.FriendshipRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.utils.factory.FriendshipFactory
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class GetFriendsServiceImplTest {

    private  val findUserAuthenticatedService = Mockito
        .mock(FindUserAuthenticatedService::class.java)

    private  val friendshipRepository = Mockito
        .mock(FriendshipRepository::class.java)

    private val getFriendsService = GetFriendsServiceImpl(
        findUserAuthenticatedService,
        friendshipRepository
    )

    @Test
    fun get() {
        val firstUser = UserAccountFactory.getUserAccount(1L)
        val secondUser = UserAccountFactory.getUserAccount(2L)
        val thirdUser = UserAccountFactory.getUserAccount(3L)
        val fourthUser = UserAccountFactory.getUserAccount(4L)

        val firstFriendShip = FriendshipFactory.getFriendShip(firstUser, secondUser, 1L)
        firstFriendShip.relation = Relation.FRIENDS
        val secondFriendShip = FriendshipFactory.getFriendShip(firstUser, thirdUser, 2L)
        secondFriendShip.relation = Relation.FRIENDS
        val thirdFriendShip = FriendshipFactory.getFriendShip(fourthUser, firstUser, 3L)
        thirdFriendShip.relation = Relation.FRIENDS

        val friendshipList = listOf(
            firstFriendShip,
            secondFriendShip,
            thirdFriendShip
        )

        val expected = listOf(
            secondUser,
            thirdUser,
            fourthUser
        )

        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(firstUser)
        Mockito.`when`(friendshipRepository.filterFriendsByUser(firstUser.id!!, Relation.FRIENDS)).thenReturn(friendshipList)

        val result = getFriendsService.get()

        Mockito.verify(findUserAuthenticatedService).user
        Mockito.verify(friendshipRepository).filterFriendsByUser(firstUser.id!!, Relation.FRIENDS)

        Assertions.assertEquals(expected, result)

        Mockito.verifyNoMoreInteractions(
            findUserAuthenticatedService,
            friendshipRepository
        )

    }
}