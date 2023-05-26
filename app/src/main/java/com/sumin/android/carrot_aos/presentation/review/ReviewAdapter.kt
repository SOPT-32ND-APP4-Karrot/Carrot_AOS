package com.sumin.android.carrot_aos.presentation.review

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sumin.android.carrot_aos.R
import com.sumin.android.carrot_aos.data.model.response.ReviewResponse
import com.sumin.android.carrot_aos.databinding.ItemReviewCardBinding
import com.sumin.android.carrot_aos.util.extension.ItemDiffCallback

class ReviewAdapter(context: Context) :
    ListAdapter<ReviewResponse.Review, RecyclerView.ViewHolder>(
        ItemDiffCallback<ReviewResponse.Review>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {
    private val inflater by lazy { LayoutInflater.from(context) }
    private val context = context
    private lateinit var sellerNickname: String

    class ReviewCardViewHolder(
        private val binding: ItemReviewCardBinding,
        private val sellerNickname: String,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ReviewResponse.Review, viewType: Int) {
            when (viewType) {
                VIEW_TYPE_MINT -> binding.tvItemReviewTitle.text =
                    "${sellerNickname}님에게\n따뜻한 후기를 보냈어요."

                VIEW_TYPE_LIGHT_YELLOW -> {
                    with(binding) {
                        tvItemReviewTitle.text = "${sellerNickname}님이 보낸\n 따뜻한 후기가 도착했어요."
                        ivItemReviewCardImg.setImageResource(R.drawable.img_review_card_lightyellow)
                        layoutItemReviewCard.setBackgroundResource(R.drawable.shape_lightyellow_fill_20_rect)
                    }
                }
            }

            val reviewCardAdapter = ReviewCardAdapter(context = context)
            reviewCardAdapter.submitList(data.content)
            binding.rvItemReviewCardText.adapter = reviewCardAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemReviewCardBinding.inflate(inflater, parent, false)
        return ReviewCardViewHolder(binding, sellerNickname, context)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ReviewCardViewHolder -> holder.onBind(
                currentList[position],
                getItemViewType(position)
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_MINT
            else -> VIEW_TYPE_LIGHT_YELLOW
        }
    }

    fun setSellerNickname(nickname: String) {
        this.sellerNickname = nickname
    }

    companion object {
        const val VIEW_TYPE_MINT = 0
        const val VIEW_TYPE_LIGHT_YELLOW = 1
    }
}