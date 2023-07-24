package com.example.viewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CustomAdapter(activity: FragmentActivity, val list: List<Int>):FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
    return list.size
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = BlankFragment().apply {
            arguments= Bundle().apply{
                putInt("key", list[position])
            }
        }
        return fragment
    }

}