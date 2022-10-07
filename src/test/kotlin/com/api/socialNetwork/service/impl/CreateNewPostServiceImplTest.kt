package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.Post
import com.api.socialNetwork.repository.PostRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.LocalDateAndTime
import com.api.socialNetwork.utils.factory.DateTimeFactory
import com.api.socialNetwork.utils.factory.PostFactory
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

internal class CreateNewPostServiceImplTest {

    private val findUserAuthenticatedService = Mockito.mock(
        FindUserAuthenticatedService::class.java)

    private val localDateAndTime = Mockito.mock(
        LocalDateAndTime::class.java)

    private val postRepository = Mockito.mock(
        PostRepository::class.java)


    private val captor = ArgumentCaptor.forClass(Post::class.java)

    private val createNewPostServiceImpl = CreateNewPostServiceImpl(
        findUserAuthenticatedService,
        localDateAndTime,
        postRepository
    )

    @Test
    fun post() {
        val dateTime = DateTimeFactory.getDateTime()
        val userAccount = UserAccountFactory.getUserAccount()
        val expected = PostFactory.getPost(userAccount, dateTime)
        val createNewPostRequest = PostFactory.getCreateNewPostRequest()

        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(userAccount)
        Mockito.`when`(localDateAndTime.get()).thenReturn(dateTime)

        createNewPostServiceImpl.post(createNewPostRequest)

        Mockito.verify(findUserAuthenticatedService).user
        Mockito.verify(localDateAndTime).get()
        Mockito.verify(postRepository).save(captor.capture())


        Assertions.assertEquals(expected,captor.value)

        Mockito.verifyNoMoreInteractions(
            findUserAuthenticatedService,
            localDateAndTime,
            postRepository
        )
    }
}