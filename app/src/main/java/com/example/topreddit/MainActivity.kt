package com.example.topreddit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.topreddit.api.RestApi

class MainActivity : AppCompatActivity() {

    private val api: RestApi = RestApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val callResponse = api.getNews("", "")
        val response = callResponse.execute()

//        if (response.isSuccessful) {
//            val news = response.body().data.children.map {
//                val item = it.data
//                RedditNewsItem(item.author, item.title, item.num_comments,
//                    item.created, item.thumbnail, item.url)
//            }
//            subscriber.onNext(news)
//            subscriber.onCompleted()
//        } else {
//            subscriber.onError(Throwable(response.message()))
//        }

    }
}