package com.christian_magana.twitter_mirroring.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.christian_magana.twitter_mirroring.databinding.ItemTweetBinding
import com.christian_magana.twitter_mirroring.model.Tweet

class TweetsHolder(private val view:  View): RecyclerView.ViewHolder(view) {
    val binding = ItemTweetBinding.bind(view)

    fun render(tweet: Tweet){
        binding.ivProfile.setImageResource(tweet.imageProfile)
        binding.tvName.text = tweet.name
        binding.tvUserName.text = tweet.userName
        if(!tweet.verified) binding.ivVerified.visibility = View.GONE
        binding.tvTime.text = tweet.time

        tweet.text?.let { tweetText ->
            binding.tvText.apply {
                visibility = View.VISIBLE
                text = tweetText
            }
        }

        binding.tvComments.text = tweet.comments.toString()
        binding.tvRetwetts.text = tweet.retweets.toString()
        binding.tvLikes.text = tweet.likes.toString()


        tweet.images?.let {
            binding.cvImages.visibility = View.VISIBLE
            binding.iv1.setImageResource(it[0])

            if(it.size > 1){
                binding.iv2.visibility = View.VISIBLE
                binding.iv2.setImageResource(it[1])
            }
            if(it.size > 2){
                binding.iv3.visibility = View.VISIBLE
                binding.iv3.setImageResource(it[2])
            }
            if(it.size > 3){
                binding.iv4.visibility = View.VISIBLE
                binding.iv4.setImageResource(it[3])
            }
        }



    }
}