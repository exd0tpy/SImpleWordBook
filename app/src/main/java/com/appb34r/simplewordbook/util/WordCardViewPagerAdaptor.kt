package com.appb34r.simplewordbook.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.appb34r.simplewordbook.R
import com.appb34r.simplewordbook.data.WordCard
import org.w3c.dom.Text

class WordCardViewPagerAdaptor (
    var wordCards: List<WordCard>,
    var context: Context?
) : RecyclerView.Adapter<WordCardViewPagerAdaptor.AdapterViewHolder>() {

    override fun getItemCount(): Int {
        return wordCards.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.word_card_item, parent, false)
        return AdapterViewHolder(v)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val item = wordCards[position]
        holder.wordTitleTextView.text = item.word
        holder.wordMeaningTextView.text = item.meaning
        if(item.stared) {
            holder.importantStarButton.setImageResource(android.R.drawable.star_big_on)
        }

    }

    inner class AdapterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val wordTitleTextView: TextView = view.findViewById(R.id.wordTitleTextView)
        val wordMeaningTextView: TextView = view.findViewById(R.id.wordMeaningTextView)
        val importantStarButton: ImageButton = view.findViewById(R.id.importantStarButton)
    }
}