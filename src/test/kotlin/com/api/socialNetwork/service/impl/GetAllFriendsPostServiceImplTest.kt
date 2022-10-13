package com.api.socialNetwork.service.impl

import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.GetFriendsService
import com.api.socialNetwork.utils.factory.PostFactory
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

internal class GetAllFriendsPostServiceImplTest {

    private  val findUserAuthenticatedService = Mockito
        .mock(FindUserAuthenticatedService::class.java)

    private  val getFriendsService = Mockito
        .mock(GetFriendsService::class.java)


    private val  getAllFriendsPostServiceImpl=GetAllFriendsPostServiceImpl(
        findUserAuthenticatedService,
        getFriendsService
    )

    @Test
    fun getTest() {

        val firstUser = UserAccountFactory.getUserAccount(1L)
        val secondUser = UserAccountFactory.getUserAccount(2L)
        val thirdUser = UserAccountFactory.getUserAccount(3L)
        val fourthUser = UserAccountFactory.getUserAccount(4L)

        val firstUserFirstPost = PostFactory.getPost(firstUser, 1L)
        val firstUserSecondPost = PostFactory.getPost(firstUser, 2L)
        val secondUserFirstPost = PostFactory.getPost(secondUser, 3L)
        val secondUserSecondPost = PostFactory.getPost(secondUser, 4L)
        val thirdUserFirstPost = PostFactory.getPost(thirdUser, 5L)
        val thirdUserSecondPost = PostFactory.getPost(thirdUser, 6L)
        val fourthUserFirstPost = PostFactory.getPost(fourthUser, 7L)
        val fourthUserSecondPost = PostFactory.getPost(fourthUser, 8L)

        firstUserFirstPost.userAccountList.add(firstUser)
        firstUserSecondPost.userAccountList.add(firstUser)
        secondUserFirstPost.userAccountList.add(secondUser)
        secondUserSecondPost.userAccountList.add(secondUser)
        thirdUserFirstPost.userAccountList.add(thirdUser)
        thirdUserSecondPost.userAccountList.add(thirdUser)
        fourthUserFirstPost.userAccountList.add(fourthUser)
        fourthUserSecondPost.userAccountList.add(fourthUser)

        firstUser.postList.add(firstUserFirstPost)
        firstUser.postList.add(firstUserSecondPost)
        secondUser.postList.add(secondUserFirstPost)
        secondUser.postList.add(secondUserSecondPost)
        thirdUser.postList.add(thirdUserFirstPost)
        thirdUser.postList.add(thirdUserSecondPost)
        fourthUser.postList.add(fourthUserFirstPost)
        fourthUser.postList.add(fourthUserSecondPost)

        val friendshipList = listOf(
            secondUser,
            thirdUser,
            fourthUser
        )

        val expected = listOf(
            firstUserFirstPost,
            firstUserSecondPost,
            secondUserFirstPost,
            secondUserSecondPost,
            thirdUserFirstPost,
            thirdUserSecondPost,
            fourthUserFirstPost,
            fourthUserSecondPost
        )

        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(firstUser)
        Mockito.`when`(getFriendsService.get()).thenReturn(friendshipList)

        val result = getAllFriendsPostServiceImpl.get()

        Assertions.assertEquals(expected,result)

        println(result)
    }
}