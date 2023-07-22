package com.example.viewpager2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlin.math.acos

class CustomAdapter(activity: FragmentActivity):FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
    return 10
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = BlankFragment().apply {
            arguments= Bundle().apply{
                putString("key", "Page: $position")
            }
        }
        return fragment
    }

}