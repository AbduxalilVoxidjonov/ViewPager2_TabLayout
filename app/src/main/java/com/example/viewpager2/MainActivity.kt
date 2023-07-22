package com.example.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import com.example.viewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private  val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customAdapter = CustomAdapter(this)
        binding.myViewPager2.adapter= customAdapter

        TabLayoutMediator(binding.tableLayout, binding.myViewPager2){tab, position ->
            tab.text = "Tab: $position"
        }.attach()


    }
}