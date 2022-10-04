package com.api.socialNetwork.model

import com.api.socialNetwork.dtos.request.CreateNewPostRequest
import com.fasterxml.jackson.annotation.JsonIgnore
import net.bytebuddy.asm.Advice.AllArguments
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
)