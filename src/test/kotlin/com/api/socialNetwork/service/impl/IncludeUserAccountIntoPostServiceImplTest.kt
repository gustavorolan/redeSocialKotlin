package com.api.socialNetwork.service.impl

import com.api.socialNetwork.controller.dtos.request.IncludeUserAccountIntoPostRequest
import com.api.socialNetwork.model.Post
import com.api.socialNetwork.repository.PostRepository
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.finder.impl.PostFinderByIdImpl
import com.api.socialNetwork.service.validator.IncludeUserAccountIntoPostValidation.IncludeUserAccountIntoPostValidation
import com.api.socialNetwork.utils.factory.DateTimeFactory
import com.api.socialNetwork.utils.factory.PostFactory
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

internal class IncludeUserAccountIntoPostServiceImplTest {

    private val findUserAuthenticatedService = Mockito.mock(
        FindUserAuthenticatedService::class.java)

    private val postFinderByIdImpl = Mockito.mock(
        PostFinderByIdImpl::class.java)

    private val postRepository = Mockito.mock(
        PostRepository::class.java)

    private val includeUserAccountIntoPostValidationList = Mockito.mock(
        IncludeUserAccountIntoPostValidation::class.java)

    private val captor = ArgumentCaptor.forClass(Post::class.java)

    private val includeUserAccountIntoPostServiceImpl = IncludeUserAccountIntoPostServiceImpl(
        findUserAuthenticatedService,
        postFinderByIdImpl,
        postRepository,
        listOf(includeUserAccountIntoPostValidationList)
    )

    @Test
    fun includeUserAccount() {
        val dateTime = DateTimeFactory.getDateTime()
        val creator = UserAccountFactory.getUserAccount(1L)
        val userToInclude = UserAccountFactory.getUserAccount(2L)
        val post = PostFactory.getPost(creator, dateTime)
        val expected = listOf(1L,2L)
        val request=IncludeUserAccountIntoPostRequest(idPost=1L)

        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(userToInclude)
        Mockito.`when`(postFinderByIdImpl.findByIdWithException(request.idPost)).thenReturn(post)


        includeUserAccountIntoPostServiceImpl.includeUserAccount(request)

        Mockito.verify(findUserAuthenticatedService).user
        Mockito.verify(postFinderByIdImpl).findByIdWithException(request.idPost)
        Mockito.verify(includeUserAccountIntoPostValidationList).validate(post)
        Mockito.verify(postRepository).save(captor.capture())

        val idList = captor.value.userAccountList.map { it.id }

        Assertions.assertEquals(expected,idList)
        Assertions.assertTrue(userToInclude.postList.contains(post))
        Assertions.assertTrue(post.userAccountList.contains(userToInclude))

        Mockito.verifyNoMoreInteractions(
            findUserAuthenticatedService,
            postFinderByIdImpl,
            postRepository,
            includeUserAccountIntoPostValidationList
        )
    }
}