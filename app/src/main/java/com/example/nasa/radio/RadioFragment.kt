package com.example.nasa.radio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nasa.R
import com.example.nasa.common.mvp.BaseFragment
import com.example.nasa.databinding.FragmentRadioBinding
import com.example.nasa.utils.Utils.RADIO_ID
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener

class RadioFragment : BaseFragment(R.layout.fragment_radio) {

    private lateinit var binding: FragmentRadioBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRadioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.addObserver(binding.youtubePlayerView)

        binding.bottomNavigationBar.setOnClickListener {
            Toast.makeText(this.context, "Only video stream is available", Toast.LENGTH_LONG).show()
        }
        binding.bottomNavigationBar. setOnClickListener {
            Toast.makeText(this.context, "Only video stream is available", Toast.LENGTH_LONG).show()
        }

        binding.youtubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(RADIO_ID, 0f)
            }
        })

    }
}