package com.api.socialNetwork.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.Hibernate
import java.time.LocalDateTime
import javax.persistence.*

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
    val userAccountList: List<UserAccount>? = ArrayList(),

    @OneToMany(mappedBy = "postCommented")
    @JsonIgnore
    val commentList: List<Comment>? = ArrayList(),

    @OneToMany(mappedBy = "postLiked")
    @JsonIgnore
    val likePostList: List<LikePost> = ArrayList(),

    @Column(nullable = false)
    val privatePost: Boolean = false,

    @Column(nullable = false)
    val postText: String? = "",

    val postImg: String? = "",

    @Column(nullable = false)
    val dateTime: LocalDateTime? = LocalDateTime.now(),

    val likes: Int? = 0,

    val comments: Int? = 0,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Post

        return postId != null && postId == other.postId
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(postId = $postId )"
    }
}