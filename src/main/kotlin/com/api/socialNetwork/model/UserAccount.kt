package com.api.socialNetwork.model

import com.api.socialNetwork.dtos.request.CreateNewUserRequest
import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import javax.persistence.*

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
    val profileImg: String ?= "",

    @JsonIgnore
    @ManyToMany(mappedBy = "userAccountList", cascade = [CascadeType.ALL])
    val postList: List<Post> ?= ArrayList(),

    @OneToMany(mappedBy = "userAccount")
    @JsonIgnore
    val likePostList: List<LikePost>? = ArrayList(),

    @OneToMany(mappedBy = "userAccount")
    @JsonIgnore
    val commentList: List<Comment> ?= ArrayList(),

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "userIdPermission")
    val permissionList: List<Permission> ?= ArrayList(),

    @OneToMany(mappedBy = "userAccount")
    val notificationList: List<Notification>? = ArrayList()
) {
    constructor(request:CreateNewUserRequest) :
            this( userId = null,
                username = request.username,
                nickname = request.nickname,
                email = request.email,
                password = request.password,
                profileImg = null,
                postList = null,
                likePostList = null,
                commentList = null,
                permissionList = null)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as UserAccount

        return userId != null && userId == other.userId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(userId = $userId )"
    }
}