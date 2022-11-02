package com.api.socialNetwork.model

import com.api.socialNetwork.controller.dtos.request.CreateNewUserRequest
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Suppress("com.haulmont.jpb.DataClassEqualsAndHashCodeInspection")
@Entity
data class  UserAccount(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    var id: Long? = null,

    @Column(nullable = false)
    var username: String,

    @Column(nullable = false, unique = true)
    var nickname: String,

    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Column
    var profileImg: String? = "",

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
            this(
                id = null,
                username = request.username,
                nickname = request.nickname,
                email = request.email,
                password = request.password,
                profileImg = "",
                postList = mutableListOf(),
                likePostList = mutableListOf(),
                commentList = mutableListOf(),
                permissionList = mutableListOf())

    override fun toString(): String {
        return "UserAccount(userId=$id, username='$username', nickname='$nickname', email='$email', password='$password', profileImg=$profileImg, postList=$postList, permissionList=$permissionList)"
    }

}