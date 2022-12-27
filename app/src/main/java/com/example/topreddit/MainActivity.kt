package com.example.topreddit

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.topreddit.api.RedditApi
import com.example.topreddit.model.RedditNewsDataResponse
import com.example.topreddit.model.RedditNewsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var newsAdapter: NewsAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager

        getData()

    }

    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.reddit.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(RedditApi::class.java)

        val retrofitData = retrofit.getTop()

        retrofitData.enqueue(object : Callback<List<RedditNewsResponse>?> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<List<RedditNewsResponse>?>, response: Response<List<RedditNewsResponse>?>) {

                val responseBody = response.body()!!

                newsAdapter = NewsAdapter(baseContext, responseBody)

                val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
                recyclerView.adapter = newsAdapter
            }

            override fun onFailure(call: Call<List<RedditNewsResponse>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure" + t.message)
            }
        })
    }
}