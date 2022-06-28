package com.christian_magana.twitter_mirroring.ui.home

import android.content.res.ColorStateList
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.christian_magana.twitter_mirroring.R
import com.christian_magana.twitter_mirroring.databinding.ItemTweetBinding
import com.christian_magana.twitter_mirroring.data.Tweet


class TweetsHolder(private val view:  View): RecyclerView.ViewHolder(view) {
    private val binding = ItemTweetBinding.bind(view)

    fun render(tweet: Tweet, onClick: (idTweet: Long) -> Unit) {
        binding.containerTweet.setOnClickListener { onClick(tweet.id) }
        binding.ivProfile.setImageResource(tweet.imageProfile)
        binding.tvName.text = tweet.name
        binding.tvUserName.text = tweet.nickName
        if(!tweet.verified) binding.ivVerified.visibility = View.GONE
        binding.tvTime.text = tweet.datetime_simplified

        tweet.text?.let { tweetText ->
            binding.tvText.apply {
                visibility = View.VISIBLE
                setText(findHashtagsAndMentions(tweetText), TextView.BufferType.SPANNABLE)
            }
        }


        if(tweet.isLiked) {
            binding.ivLikes.setImageResource(R.drawable.ic_liked_twitter)
            binding.ivLikes.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(view.context, R.color.like_color))
            binding.tvLikes.setTextColor(ContextCompat.getColor(view.context, R.color.like_color))
        }
        if(tweet.isRetweeted){
            binding.tvRetwets.setTextColor(ContextCompat.getColor(view.context, R.color.retweet_color))
            binding.ivRetwet.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(view.context, R.color.retweet_color))
        }

        binding.tvComments.text = tweet.nQuoteTweets.toString()
        binding.tvRetwets.text = tweet.nRetweets.toString()
        binding.tvLikes.text = tweet.nLikes.toString()

        tweet.images?.let {
            binding.cvImages.visibility = View.VISIBLE

            if(it.size > 1){
                binding.iv1.visibility = View.VISIBLE
                Glide.with(view.context).load(it[0]).centerCrop().into(binding.iv1)

                binding.iv2.visibility = View.VISIBLE
                Glide.with(view.context).load(it[1]).centerCrop().into(binding.iv2)

                binding.iv3.visibility = View.VISIBLE
                Glide.with(view.context).load(it[2]).centerCrop().into(binding.iv3)

                binding.iv4.visibility = View.VISIBLE
                Glide.with(view.context).load(it[3]).centerCrop().into(binding.iv4)
            }else{
                binding.ivTweet.visibility = View.VISIBLE
                Glide.with(view.context).load(it[0]).centerCrop().into(binding.ivTweet)
            }

        }



    }


    private fun findHashtagsAndMentions(text: String): SpannableStringBuilder {
        val spannable = SpannableStringBuilder(text)
        val pattern = "(#[a-zA-Z0-9_]+)|(@[a-zA-Z0-9_]+)"
        val regex = Regex(pattern)
        val matches = regex.findAll(text)
        matches.forEach {
            val start = it.range.first
            val end = it.range.last + 1
            spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(view.context, R.color.blue)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        return spannable
    }








}
