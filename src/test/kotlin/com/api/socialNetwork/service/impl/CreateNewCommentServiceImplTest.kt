package com.api.socialNetwork.service.impl

import com.api.socialNetwork.model.Comment
import com.api.socialNetwork.repository.CommentRepositoryInterface
import com.api.socialNetwork.security.FindUserAuthenticatedService
import com.api.socialNetwork.service.finder.impl.PostFinderByIdImpl
import com.api.socialNetwork.utils.factory.CommentFactory
import com.api.socialNetwork.utils.factory.DateTimeFactory
import com.api.socialNetwork.utils.factory.PostFactory
import com.api.socialNetwork.utils.factory.UserAccountFactory
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito

internal class CreateNewCommentServiceImplTest {

    private  val findUserAuthenticatedService = Mockito
        .mock(FindUserAuthenticatedService::class.java)

    private val commentRepository= Mockito
        .mock(CommentRepositoryInterface::class.java)

    private val postFinderByIdImp = Mockito
        .mock(PostFinderByIdImpl::class.java)

    private val captor = ArgumentCaptor.forClass(Comment::class.java)

    private val createNewCommentServiceImpl = CreateNewCommentServiceImpl(
        findUserAuthenticatedService,
        commentRepository,
        postFinderByIdImp,
    )

    @Test
    fun post() {
        val dateTime = DateTimeFactory.getDateTime()
        val userAccount = UserAccountFactory.getUserAccount()
        val post = PostFactory.getPost(userAccount, dateTime)
        val expected = CommentFactory.getComment(userAccount, post)
        val request = CommentFactory.getCommentRequest()
        val expectedCommentsQuantity = 1
        val expectedCommentString = "comment"

        Mockito.`when`(findUserAuthenticatedService.user).thenReturn(userAccount)
        Mockito.`when`(postFinderByIdImp.findByIdWithException(request.postId)).thenReturn(post)

        createNewCommentServiceImpl.post(request)

        Mockito.verify(findUserAuthenticatedService).user
        Mockito.verify(postFinderByIdImp).findByIdWithException(request.postId)
        Mockito.verify(commentRepository).save(captor.capture())

        Assertions.assertEquals(expected, captor.value)
        Assertions.assertEquals(expectedCommentsQuantity,post.comments)
        Assertions.assertEquals(expectedCommentsQuantity,post.commentList.size)
        Assertions.assertEquals(expectedCommentString,post.commentList[0].commentText)
    }
}