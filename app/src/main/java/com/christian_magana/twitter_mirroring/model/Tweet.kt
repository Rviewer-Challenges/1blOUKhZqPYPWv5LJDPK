package com.christian_magana.twitter_mirroring.model

import android.graphics.drawable.Drawable


data class Tweet(
     val imageProfile: Int,
     val name: String,
     val userName: String,
     val verified: Boolean,
     val text: String?,
     val time: String,
     val images: ArrayList<Int>?,
     val likes: Int,
     val comments: Int,
     val retweets: Int
     )
