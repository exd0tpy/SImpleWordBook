package com.appb34r.simplewordbook.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.viewpager2.widget.ViewPager2
import com.appb34r.simplewordbook.R
import com.appb34r.simplewordbook.data.WordCard
import com.appb34r.simplewordbook.util.WordCardViewPagerAdaptor

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val rightButton: ImageButton = view.findViewById(R.id.rightScrollButton)
        val leftButton: ImageButton = view.findViewById(R.id.leftScrollButton)
        viewPager = view.findViewById(R.id.wordCardViewPager)
        rightButton.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem + 1
        }
        leftButton.setOnClickListener {
            viewPager.currentItem = if(viewPager.currentItem > 0) viewPager.currentItem - 1 else viewPager.currentItem
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val dummyData = listOf<WordCard>(
            WordCard("water", "모어쌍", true),
            WordCard("orange", "오뤼잉~~쥐", false),
            WordCard("hello", "혤레후", false),
            WordCard("thank", "쁘앵크", true)
        )
        viewPager.adapter = WordCardViewPagerAdaptor(dummyData, context)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            // Paging 완료되면 호출
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("ViewPagerFragment", "Page ${position+1}")
            }
        })

    }

}