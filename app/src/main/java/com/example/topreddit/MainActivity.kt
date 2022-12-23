package com.example.topreddit

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.topreddit.api.RestApi

class MainActivity : AppCompatActivity() {

    private val api: RestApi = RestApi()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val response = api.getNews()

        if(response.execute().isSuccessful) {
            val news = response.execute().body()?.data?.children?.map {
                val item = it.data
            }
        }


//        val listview = findViewById<ListView>(R.id.listView)
//        val arrayAdapter: ArrayAdapter<*>
//        val users = arrayOf(
//            "user1", "user2", "user3"
//        )
//
//        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, users)
//        listview.adapter = arrayAdapter

//        if(response.isSuccessful) {
//            val news = response.body()?.data?.children?.map {
//                val item = it.data
//            }
//        }



//        textView.setText("hello world").toString()

    }
}