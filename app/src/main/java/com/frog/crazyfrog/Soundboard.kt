package com.frog.crazyfrog

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.frog.crazyfrog.databinding.FragmentSoundboardBinding
import android.media.MediaPlayer
import android.widget.ImageView
import android.widget.LinearLayout

/**
 * A simple [Fragment] subclass.
 * Use the [Soundboard.newInstance] factory method to
 * create an instance of this fragment.
 */
class Soundboard : Fragment() {

    private lateinit var binding : FragmentSoundboardBinding
    private var mMediaPlayer : MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_soundboard, container, false)
        setListeners()
        return binding.root
    }

    private fun setListeners(){
        binding.buttonSoundOne.setOnClickListener { SoundBoardPlay("soundOne" , binding.imageView1, binding.buttonSoundOne) }
        binding.buttonSoundTwo.setOnClickListener{SoundBoardPlay("soundTwo" , binding.imageView2, binding.buttonSoundTwo)}
        binding.buttonSoundThree.setOnClickListener{SoundBoardPlay("soundThree", binding.imageView3, binding.buttonSoundThree)}

    }

    private fun SoundBoardPlay(sound : String , imageview : ImageView, linearlayout : LinearLayout){
        when(sound){
            "soundOne" -> mMediaPlayer = MediaPlayer.create(context, R.raw.dingding)
            "soundTwo" -> mMediaPlayer = MediaPlayer.create(context, R.raw.axelf_remix)
            "soundThree" -> mMediaPlayer = MediaPlayer.create(context, R.raw.crazy_frog_3)
        }
        mMediaPlayer!!.isLooping = false
        mMediaPlayer!!.start()
        imageview.setImageResource(R.drawable.custom_stopbutton)
        linearlayout.setOnClickListener{mMediaPlayer!!.stop()
            linearlayout.setOnClickListener{SoundBoardPlay(sound, imageview, linearlayout)}
            imageview.setImageResource(R.drawable.custom_playbutton)}
        mMediaPlayer!!.setOnCompletionListener { imageview.setImageResource(R.drawable.custom_playbutton)
            linearlayout.setOnClickListener{SoundBoardPlay(sound, imageview, linearlayout)}}
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            Soundboard()
    }
}