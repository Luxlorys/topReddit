package com.example.topreddit

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.topreddit.api.RedditApi
import com.example.topreddit.api.RestApi
import com.example.topreddit.model.RedditNewsResponse
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private val api: RestApi = RestApi()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()


    }

    private fun getData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.reddit.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(RedditApi::class.java)

        val retrofitData = retrofit.getTop()

        retrofitData.enqueue(object : Callback<RedditNewsResponse?> {
            override fun onResponse(
                call: Call<RedditNewsResponse?>,
                response: Response<RedditNewsResponse?>
            ) {
                val sb = StringBuilder()

                val responseBody = response.body()?.data?.children?.forEach() {
                    val item = it.data
                    sb.append(item.title)
                }

                val textView = findViewById<TextView>(R.id.title)

                textView.text = sb

            }

            override fun onFailure(call: Call<RedditNewsResponse?>, t: Throwable) {}
        })
    }
}