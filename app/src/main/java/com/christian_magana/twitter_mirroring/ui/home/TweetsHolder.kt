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
                setText(findHashtags(tweetText), TextView.BufferType.SPANNABLE)
            }
        }

        binding.tvComments.text = tweet.comments.toString()
        binding.tvRetwets.text = tweet.retweets.toString()
        binding.tvLikes.text = tweet.likes.toString()

        initClicks()


        tweet.images?.let {
            binding.cvImages.visibility = View.VISIBLE
            Glide.with(view.context).load(it[0]).centerCrop().into(binding.iv1)

            if(it.size > 1){
                binding.iv2.visibility = View.VISIBLE
                Glide.with(view.context).load(it[1]).centerCrop().into(binding.iv2)
            }
            if(it.size > 2){
                binding.iv3.visibility = View.VISIBLE
                Glide.with(view.context).load(it[2]).centerCrop().into(binding.iv3)
            }
            if(it.size > 3){
                binding.iv4.visibility = View.VISIBLE
                Glide.with(view.context).load(it[3]).centerCrop().into(binding.iv4)
            }
        }



    }

    private fun initClicks() {

        binding.containerLikes.setOnClickListener {
            binding.ivLikes.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(view.context, R.color.like_color))
            binding.tvLikes.setTextColor(ContextCompat.getColor(view.context, R.color.like_color))
        }

        binding.containerRetwets.setOnClickListener {
            binding.ivRetwet.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(view.context, R.color.retwet_color))
            binding.tvRetwets.setTextColor(ContextCompat.getColor(view.context, R.color.retwet_color))
        }
    }

    private fun findHashtags(text: String): SpannableStringBuilder  {
        val spannable = SpannableStringBuilder().append(text)
        val hashTag = "#"
        val espacio = " "

        var index = text.indexOf(hashTag)
        while(index != -1){
            val indexFin = if(text.indexOf(espacio, index) == -1) text.length else text.indexOf(espacio, index)
            spannable.setSpan(ForegroundColorSpan(ContextCompat.getColor(view.context, R.color.blue)), index, indexFin, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
            index = text.indexOf(hashTag, index + 1)
        }

        return spannable
    }


}
