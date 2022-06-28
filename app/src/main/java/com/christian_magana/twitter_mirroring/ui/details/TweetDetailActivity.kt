package com.christian_magana.twitter_mirroring.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.christian_magana.twitter_mirroring.R
import com.christian_magana.twitter_mirroring.data.TweetsProvider
import com.christian_magana.twitter_mirroring.databinding.ActivityDetailsBinding
import com.christian_magana.twitter_mirroring.data.Tweet
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
        adapter = TweetsAdapter(tweet!!.replies!!){
            //Toast.makeText(this, "Clicked on ${it}", Toast.LENGTH_SHORT).show()
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
            binding.tvUserName.text = it.nickName
            binding.tvText.text = it.text
            binding.tvDateTime.text = it.datetime
            binding.tvRetweets.text = it.nRetweets.toString()
            binding.tvLikesTweet.text = it.nLikes.toString()
            binding.tvQuoteTweets.text = it.nQuoteTweets.toString()

            it.images?.let {images ->
                binding.cvImages.visibility = View.VISIBLE

                if(images.size > 1){
                    binding.iv1.visibility = View.VISIBLE
                    Glide.with(this).load(images[0]).centerCrop().into(binding.iv1)

                    binding.iv2.visibility = View.VISIBLE
                    Glide.with(this).load(images[1]).centerCrop().into(binding.iv2)

                    binding.iv3.visibility = View.VISIBLE
                    Glide.with(this).load(images[2]).centerCrop().into(binding.iv3)

                    binding.iv4.visibility = View.VISIBLE
                    Glide.with(this).load(images[3]).centerCrop().into(binding.iv4)
                }else{
                    binding.ivTweet.visibility = View.VISIBLE
                    Glide.with(this).load(images[0]).centerCrop().into(binding.ivTweet)
                }

            }
        }
    }
}