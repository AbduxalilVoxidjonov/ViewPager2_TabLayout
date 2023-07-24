package com.example.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpager2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.abs
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private  val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val list = listOf<Int>(
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4
        )
        val listName= listOf<String>(
            "Olma",
            "Banan",
            "Shaftoli",
            "Kartoshka",
            "Pomidor",
        )

       val data= listOf<CustomModelDate>(
           CustomModelDate(R.drawable.baseline_home_24,R.drawable.img,"Olma"),
           CustomModelDate(R.drawable.baseline_format_list_bulleted_24,R.drawable.img_1,"Banan"),
           CustomModelDate(R.drawable.baseline_info_24,R.drawable.img_2,"Shaftoli"),
           CustomModelDate(R.drawable.baseline_filter_list_24,R.drawable.img_3,"Kartoshka"),
           CustomModelDate(R.drawable.baseline_home_24,R.drawable.img,"Pomidor")
       )
        val customAdapter = CustomAdapter(this,data.map{it.image})
        binding.myViewPager2.adapter= customAdapter

        TabLayoutMediator(binding.tableLayout, binding.myViewPager2){tab, position ->
            tab.text = data[position].name
            tab.setIcon(data[position].icon)
            val badge = tab.orCreateBadge
            badge.number= Random.nextInt(0,100)

        }.attach()

        binding.myViewPager2.apply {
            clipToPadding=false
            clipChildren=false
            offscreenPageLimit=3

        }



        binding.myViewPager2.apply {
//            setPageTransformer(object : ViewPager2.PageTransformer {
//                override fun transformPage(page: View, position: Float) {
//                    page.apply {
//                        when{
//                            position<-1 -> alpha = 0.1f
//                            position<=1 -> {
//                                alpha = max(0.2f,1- abs(position))
//                            }
//                            position>1-> alpha = 0.1f
//                        }
//                        translationY= abs(position) *500f
//                    }
//                }
//            })

            setPageTransformer(CompositePageTransformer().apply{
                addTransformer(MarginPageTransformer(40))
                addTransformer(object:ViewPager2.PageTransformer{
                    override fun transformPage(page: View, position: Float) {
                        page.apply {
                            scaleY= (0.85f +0.15*(1-(abs(position)))).toFloat()
                        }
                    }

                })
            })
        }
    }
}