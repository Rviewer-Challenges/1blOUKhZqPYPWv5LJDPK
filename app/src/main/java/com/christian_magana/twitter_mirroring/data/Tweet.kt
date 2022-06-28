package com.christian_magana.twitter_mirroring.data


data class Tweet(
     val id: Long,
     val imageProfile: Int,
     val name: String,
     val nickName: String,
     val verified: Boolean,
     val text: String?,
     val datetime_simplified: String,
     val datetime: String,
     val images: ArrayList<Int>? = null,
     val nLikes: Int,
     val nRetweets: Int,
     val nQuoteTweets: Int,
     val isLiked: Boolean,
     val isRetweeted: Boolean,
     val replies: ArrayList<Tweet>? = null
     )
