package com.sumin.android.carrot_aos.presentation.review

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sumin.android.carrot_aos.databinding.ItemItemReviewCardTextBinding
import com.sumin.android.carrot_aos.util.extension.ItemDiffCallback

class ReviewCardAdapter(context: Context) :
    ListAdapter<String, RecyclerView.ViewHolder>(
        ItemDiffCallback<String>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {
    private val inflater by lazy { LayoutInflater.from(context) }

    class ReviewCardTextViewHolder(
        private val binding: ItemItemReviewCardTextBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: String) {
            binding.tvItemItemReviewCardText.text = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemItemReviewCardTextBinding.inflate(inflater, parent, false)
        return ReviewCardTextViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ReviewCardTextViewHolder -> holder.onBind(currentList[position])
        }
    }
}