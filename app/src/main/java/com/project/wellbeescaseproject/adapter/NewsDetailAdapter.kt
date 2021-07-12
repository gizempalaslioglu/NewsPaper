package com.project.wellbeescaseproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.wellbeescaseproject.R
import com.project.wellbeescaseproject.entity.NewsDetails

class NewsDetailAdapter(val fragmentContext: Context) : RecyclerView.Adapter<NewsDetailAdapter.NewsViewHolder>() {
    private lateinit var news: ArrayList<NewsDetails>
    private val context = fragmentContext
    class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val image:ImageView = itemView.findViewById(R.id.news_image)
        val detail:TextView = itemView.findViewById(R.id.news_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_detail_item,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentNews = news[position]
        holder.detail.text = currentNews.description
        Glide.with(context).load(currentNews.urlToImage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return news.size
    }
    fun addNews(news:ArrayList<NewsDetails>){
        this.news = news
        notifyDataSetChanged()
    }

}