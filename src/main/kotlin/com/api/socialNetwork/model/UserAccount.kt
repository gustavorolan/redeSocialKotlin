package com.api.socialNetwork.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class UserAccount(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Long? = null,

    @Column(nullable = false)
    val userName: String,

    @Column(nullable = false, unique = true)
    val nickname: String,


    @Column(nullable = false, unique = true)
    val email: String,

    @Column(nullable = false)
    val password: String,

    @Column
    val profileImg: String? = "null",

    @JsonIgnore
    @ManyToMany(mappedBy = "userAccountList", cascade = [CascadeType.ALL])
    val postList: List<Post> = ArrayList(),

    @OneToMany(mappedBy = "userAccount")
    @JsonIgnore
    val likePostList: List<LikePost>? = ArrayList(),

    @OneToMany(mappedBy = "userAccount")
    @JsonIgnore
    val commentList: List<Comment>? = ArrayList(),

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "userIdPermission")
    val permissionList: List<Permission>,

    @OneToMany(mappedBy = "userAccount")
    val notificationList: List<Notification>? = ArrayList()
)