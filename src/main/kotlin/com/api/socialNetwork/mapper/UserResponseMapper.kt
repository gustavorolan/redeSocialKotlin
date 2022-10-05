package com.api.socialNetwork.mapper

import com.api.socialNetwork.dtos.response.UserAccountResponse
import com.api.socialNetwork.dtos.response.UserWithPostsResponse
import com.api.socialNetwork.model.UserAccount
import org.springframework.stereotype.Component

@Component
class UserResponseMapper {
    fun toResponse(user: UserAccount): UserAccountResponse {
        return UserAccountResponse(
            user.userId!!,
            user.username,
            user.nickname,
            user.profileImg,
            user.email
        )
    }

    fun toResponseWithPosts(user: UserAccount): UserWithPostsResponse? {
        return UserWithPostsResponse(
            toResponse(user),
            null
        )
    }

}
