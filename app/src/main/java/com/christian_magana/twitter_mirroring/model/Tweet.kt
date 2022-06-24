package com.christian_magana.twitter_mirroring.model

import android.graphics.drawable.Drawable


data class Tweet(
     val id: Long,
     val imageProfile: Int,
     val name: String,
     val userName: String,
     val verified: Boolean,
     val text: String?,
     val time: String,
     val images: ArrayList<Int>?,
     val nLikes: Int,
     val nRetweets: Int,
     val nQuoteTweets: Int,
     val isLiked: Boolean,
     val isRetweeted: Boolean,
     )
