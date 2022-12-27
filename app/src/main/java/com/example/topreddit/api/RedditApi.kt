package com.example.topreddit.api


import com.example.topreddit.model.RedditNewsDataResponse
import com.example.topreddit.model.RedditNewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RedditApi {

    @GET("/top.json?limit=10")
    fun getTop(): Call<List<RedditNewsResponse>?>;
}