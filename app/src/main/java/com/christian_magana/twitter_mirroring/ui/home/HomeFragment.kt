package com.christian_magana.twitter_mirroring.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.christian_magana.twitter_mirroring.TweetsProvider
import com.christian_magana.twitter_mirroring.databinding.FragmentHomeBinding
import com.christian_magana.twitter_mirroring.ui.details.TweetDetailActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: TweetsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRV()

        return binding.root
    }

    private fun setupRV() {
        adapter = TweetsAdapter(TweetsProvider.listTweets){id ->
            val intent = Intent(requireActivity(), TweetDetailActivity::class.java)
            intent.putExtra(TweetDetailActivity.EXTRA_TWEET_ID, id)
            startActivity(intent)
        }

        binding.list.adapter = adapter
        binding.list.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}