package com.example.topreddit.model

class RedditDataResponse (
    val children: List<RedditChildrenResponse>,
    val after: String?,
    val before: String?
    )