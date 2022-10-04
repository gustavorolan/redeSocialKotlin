package com.api.socialNetwork.dtos.response

data class UserWithPostsResponse(
     var userAccountResponse: UserAccountResponse ,
     val postResponseList: List<PostWithUserResponse>?=ArrayList()
) {
}
