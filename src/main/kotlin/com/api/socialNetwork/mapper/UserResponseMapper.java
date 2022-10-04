package com.api.socialNetwork.mapper;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.api.socialNetwork.dtos.response.UserAccountResponse;
import com.api.socialNetwork.dtos.response.UserWithPostsResponse;
import com.api.socialNetwork.model.UserAccount;

@Component
public class UserResponseMapper {
	public UserAccountResponse toResponse (UserAccount user) {

		return new UserAccountResponse(
				Objects.requireNonNull(user.getUserId()),
				user.getUserName(),
				user.getNickname(),
				Objects.requireNonNull(user.getProfileImg()),
				user.getEmail()
 		);
	}

	public UserWithPostsResponse toResponseWithPosts (UserAccount user) {

		return new UserWithPostsResponse(
				toResponse(user),
				null
		);
	}
}
