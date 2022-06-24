package com.christian_magana.twitter_mirroring.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.christian_magana.twitter_mirroring.R
import com.christian_magana.twitter_mirroring.TweetsProvider
import com.christian_magana.twitter_mirroring.databinding.ActivityDetailsBinding
import com.christian_magana.twitter_mirroring.model.Tweet
import com.christian_magana.twitter_mirroring.ui.home.TweetsAdapter

class TweetDetailActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_TWEET_ID = "EXTRA_TWEET_ID"
    }
    var tweet: Tweet? = null

    private lateinit var adapter: TweetsAdapter

    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()


        if(intent.hasExtra(EXTRA_TWEET_ID)){
            val tweetId = intent.getLongExtra(EXTRA_TWEET_ID, -1)
            tweet =  TweetsProvider.listTweets.find { it.id == tweetId }
            updateUI()
            setupRV()
        }



    }

    private fun setupRV() {
        adapter = TweetsAdapter(arrayListOf()){
            Toast.makeText(this, "Clicked on ${it}", Toast.LENGTH_SHORT).show()
        }

        binding.rvReplys.adapter = adapter
        binding.rvReplys.layoutManager = LinearLayoutManager(this)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbarDetails)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.title_Tweet)
        binding.toolbarDetails.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun updateUI() {
        tweet?.let {
            Glide.with(this).load(it.imageProfile).into(binding.ivProfile)
            binding.tvName.text = it.name
            binding.tvUserName.text = it.userName
            binding.tvText.text = it.text
            binding.tvTime.text = it.time
            binding.tvRetweets.text = it.nRetweets.toString()
            binding.tvLikesTweet.text = it.nLikes.toString()
            binding.tvQuoteTweets.text = it.nQuoteTweets.toString()
        }
    }
}