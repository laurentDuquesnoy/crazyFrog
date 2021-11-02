package com.frog.crazyfrog

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.frog.crazyfrog.databinding.FragmentSongLinksBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [SongLinks.newInstance] factory method to
 * create an instance of this fragment.
 */
class SongLinks : Fragment(R.layout.fragment_song_links) {
    // TODO: Rename and change types of parameters

    private lateinit var binding : FragmentSongLinksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_song_links, container, false)
        setClickListeners()


        return binding.root

    }

    private fun setClickListeners(){
        binding.linearLayout.setOnClickListener { openLink(getString(R.string.song_one_link)) }
        binding.LinearLayout2.setOnClickListener { openLink(getString(R.string.song_two_link)) }
        binding.linearLayout3.setOnClickListener { openLink(getString(R.string.song_three_link)) }
        binding.linearLayout4.setOnClickListener { openLink(getString(R.string.song_four_link)) }
        binding.linearLayout5.setOnClickListener { openLink(getString(R.string.song_five_link)) }
        binding.linearLayout6.setOnClickListener { openLink(getString(R.string.song_six_link)) }
    }

    private fun openLink(url : String){
        val uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SongLinks()
    }
}