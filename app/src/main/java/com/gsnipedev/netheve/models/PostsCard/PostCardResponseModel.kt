package com.gsnipedev.netheve.models.PostsCard

import java.util.*

data class PostCardResponseModel(
    val username: String,
    val displayInfo: String,
    val textContent: String,
    val postedAt: Date,
    val likesCount: Int,
    val commentsCount: Int,
    val sharedCount: Int
)

