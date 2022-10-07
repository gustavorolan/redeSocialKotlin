package com.api.socialNetwork.model

import com.api.socialNetwork.controller.dtos.request.CreateNewUserRequest
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Suppress("com.haulmont.jpb.DataClassEqualsAndHashCodeInspection")
@Entity
data class  UserAccount(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Long? = null,

    @Column(nullable = false)
    val username: String,

    @Column(nullable = false, unique = true)
    val nickname: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Column
    val profileImg: String? = "",

    @JsonIgnore
    @ManyToMany(mappedBy = "userAccountList", cascade = [CascadeType.ALL])
    val postList: MutableList<Post> = mutableListOf(),

    @OneToMany(mappedBy = "userAccount")
    @JsonIgnore
    val likePostList: MutableList<LikePost> = mutableListOf(),

    @OneToMany(mappedBy = "userAccount")
    @JsonIgnore
    val commentList: MutableList<Comment> = mutableListOf(),

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "userIdPermission")
    val permissionList: MutableList<Permission> = mutableListOf(),
) {
    constructor(request: CreateNewUserRequest) :
            this( userId = null,
                username = request.username,
                nickname = request.nickname,
                email = request.email,
                password = request.password,
                profileImg = "",
                postList = mutableListOf(),
                likePostList = mutableListOf(),
                commentList = mutableListOf(),
                permissionList = mutableListOf())

}