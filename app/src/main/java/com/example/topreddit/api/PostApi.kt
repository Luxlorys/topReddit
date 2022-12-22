package com.example.topreddit.api

import com.example.topreddit.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface PostApi {

    @get:GET("posts")
    val posts: Call<List<PostModel?>?>?

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com"
    }
}