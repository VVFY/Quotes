package com.vvfy.quotelist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vvfy.quotelist.databinding.QuoteItemBinding
import com.vvfy.quotelist.ui.components.QuoteContent
import com.vvfy.quotelist.ui.vo.QuoteWithColor

class QuoteAdapter : ListAdapter<QuoteWithColor, QuoteAdapter.QuoteViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return QuoteViewHolder(QuoteItemBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class QuoteViewHolder(
        private val binding: QuoteItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: QuoteWithColor) {
            with(binding.composeView) {
                setContent {
                    QuoteContent(
                        quote = item,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<QuoteWithColor>() {
            override fun areItemsTheSame(
                oldItem: QuoteWithColor,
                newItem: QuoteWithColor
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: QuoteWithColor,
                newItem: QuoteWithColor
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
