package com.example.topreddit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.topreddit.model.RedditNewsDataResponse
import com.example.topreddit.model.RedditNewsResponse

class NewsAdapter(private val context: Context, private val newsList: List<RedditNewsResponse>): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var titleId: TextView
        var dateId: TextView

        init {
            titleId = itemView.findViewById(R.id.title)
            dateId = itemView.findViewById(R.id.created)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.news_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleId.text = newsList[position].data.children[position].data.title
        holder.dateId.text = newsList[position].data.children[position].data.created.toString()
//        holder.titleId.text = newsList.title
//        holder.dateId.text = newsList.created.toString()
    }

    override fun getItemCount(): Int {
        return 10;
    }


}