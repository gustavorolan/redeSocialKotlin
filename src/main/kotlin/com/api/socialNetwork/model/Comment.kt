package com.api.socialNetwork.model
import javax.persistence.*

@Suppress("com.haulmont.jpb.DataClassEqualsAndHashCodeInspection")
@Entity
data class Comment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val commentId: Long? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "userId")
    val userAccount: UserAccount,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "postId")
    val postCommented: Post,

    @Column(nullable = false)
    val commentText: String = ""
){
    constructor(
        userAccount: UserAccount,
        postCommented: Post,
        commentText: String
    ):this(
        null,
        userAccount,
        postCommented,
        commentText
    )
}