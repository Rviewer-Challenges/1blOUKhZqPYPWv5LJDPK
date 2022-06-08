package com.christian_magana.twitter_mirroring.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.christian_magana.twitter_mirroring.databinding.ItemTweetBinding

class TweetsHolder(private val view:  View): RecyclerView.ViewHolder(view) {
    val binding = ItemTweetBinding.bind(view)

    fun render(tweet: String){

    }
}