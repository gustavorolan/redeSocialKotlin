package com.api.socialNetwork.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

@Suppress("com.haulmont.jpb.DataClassEqualsAndHashCodeInspection")
@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var postId: Long? = null,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "postUser",
        joinColumns = [JoinColumn(name = "postId")],
        inverseJoinColumns = [JoinColumn(name = "userId")]
    )
    val userAccountList: MutableList<UserAccount> = mutableListOf(),

    @OneToMany(mappedBy = "postCommented")
    @JsonIgnore
    val commentList: MutableList<Comment> = mutableListOf(),

    @OneToMany(mappedBy = "postLiked")
    @JsonIgnore
    val likePostList: MutableList<LikePost> = mutableListOf(),

    @Column(nullable = false)
    val privatePost: Boolean = false,

    @Column(nullable = false)
    val postText: String = "",

    val postImg: String ?= "",

    @Column(nullable = false)
    val dateTime: LocalDateTime = LocalDateTime.now(),

    var likes: Int = 0,

    var comments: Int = 0,
){
    constructor(
        userAccount: UserAccount,
        privatePost: Boolean,
        postText: String,
        postImg: String,
        dateTime: LocalDateTime,

    ):this(
        postId = null,
       userAccountList = mutableListOf(userAccount),
       commentList =  mutableListOf(),
       likePostList = mutableListOf(),
       privatePost = privatePost,
        postText= postText,
        postImg = postImg,
        dateTime=dateTime,
        0,
        0
    )
}
