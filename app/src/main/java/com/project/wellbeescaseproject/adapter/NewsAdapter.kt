@file:Suppress("Annotator")

package com.project.wellbeescaseproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.project.wellbeescaseproject.databinding.CardDesignBinding
import com.project.wellbeescaseproject.entity.News
import com.project.wellbeescaseproject.fragment.HomepageFragmentDirections
import com.project.wellbeescaseproject.viewmodel.HomepageFragmentViewModel

class NewsAdapter(var mContext: Context, var newsList:List<News>, var viewModel:HomepageFragmentViewModel)
    : RecyclerView.Adapter<NewsAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(cardDesignBinding:CardDesignBinding) :
        RecyclerView.ViewHolder(cardDesignBinding.root) {
        var cardDesignBinding:CardDesignBinding

        init {
            this.cardDesignBinding=cardDesignBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater= LayoutInflater.from(mContext)
        val design=CardDesignBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(design)

    }
    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val news = newsList.get(position)

        holder.cardDesignBinding.newsObject = news

        //when the card is clicked
        holder.cardDesignBinding.newsCard.setOnClickListener {
            val pass = HomepageFragmentDirections.detailPass(news.id)
            Navigation.findNavController(it).navigate(pass)
        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}