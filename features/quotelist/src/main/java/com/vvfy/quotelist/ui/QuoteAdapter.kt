package com.vvfy.quotelist.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vvfy.quotelist.R
import com.vvfy.quotelist.ui.vo.QuoteWithColor
import com.vvfy.quotelist.databinding.QuoteItemBinding

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
            with(binding) {
                quoteText.text = item.quote
                author.text = root.context.getString(R.string.author, item.author)
                root.setBackgroundColor(root.context.getColor(item.backgroundColor))
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
