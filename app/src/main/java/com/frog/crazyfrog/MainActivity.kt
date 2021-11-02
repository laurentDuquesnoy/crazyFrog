package com.frog.crazyfrog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.frog.crazyfrog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.locateButton.setOnClickListener{handleClick()}
        fillFacts()
        binding.rootScoll.scrollTo(0, binding.rootScoll.top)
    }

    private fun handleClick(){
        val intent = Intent(this, Locator::class.java)
        startActivity(intent)
    }

    private fun fillFacts(){
        val facts = arrayOf(
            getString(R.string.fact_one),
            getString(R.string.fact_two),
            getString(R.string.fact_three),
            getString(R.string.fact_four)
        )
        val adapter = ArrayAdapter(this, R.layout.facts_list_item, facts)
        binding.factList.adapter = adapter
    }

}