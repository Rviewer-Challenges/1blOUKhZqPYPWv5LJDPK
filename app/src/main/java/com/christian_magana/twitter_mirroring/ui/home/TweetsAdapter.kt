package com.christian_magana.twitter_mirroring.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.christian_magana.twitter_mirroring.R
import com.christian_magana.twitter_mirroring.data.Tweet

class TweetsAdapter(private var tweets: ArrayList<Tweet>, private val onClick: (idTweet: Long) -> Unit):
    RecyclerView.Adapter<TweetsHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TweetsHolder(layoutInflater.inflate(R.layout.item_tweet, parent, false))
    }

    override fun onBindViewHolder(holder: TweetsHolder, position: Int) {
        val tweet = tweets[position]
        holder.render(tweet, onClick)
    }

    override fun getItemCount(): Int = tweets.size
}