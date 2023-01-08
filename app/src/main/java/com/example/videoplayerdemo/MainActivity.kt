package com.example.videoplayerdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.videoplayerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mediaController: android.widget.MediaController
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        getViedoPlayer()
    }

    private fun dismissProgressBar() {
        binding.videoView.setOnPreparedListener({
            binding.progressBar.visibility = View.GONE
            binding.tvLoad.text = ""
        })
    }


    private fun getViedoPlayer() {

        mediaController = android.widget.MediaController(this)
        mediaController.setAnchorView(binding.videoView)
        binding.videoView.setVideoPath("https://videocdn.bodybuilding.com/video/mp4/62000/62792m.mp4")
        binding.videoView.start()
        binding.videoView.setMediaController(mediaController)
        dismissProgressBar()
    }

}

