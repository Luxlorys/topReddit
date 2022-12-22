package com.example.topreddit

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.topreddit.api.PostApi
import com.example.topreddit.model.PostModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl(PostApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build();

        val api: PostApi = retrofit.create(PostApi::class.java)
        val call: Call<List<PostModel?>?>? = api.posts

        call?.enqueue(object:Callback<List<PostModel?>?> {
            override fun onResponse(
                call: Call<List<PostModel?>?>,
                response: Response<List<PostModel?>?>
            ) {
                val postList: List<PostModel>? = response.body() as List<PostModel>?
                val post = arrayOfNulls<String>(postList!!.size)

                for (i in postList.indices) post[i] = postList[i].title

                val adapter = ArrayAdapter<String>(
                    applicationContext,
                    android.R.layout.simple_dropdown_item_1line,
                    post)

                val listview = findViewById<ListView>(R.id.listview)
                listview.adapter = adapter

            }

            override fun onFailure(call: Call<List<PostModel?>?>, t: Throwable) {}

        })
    }
}