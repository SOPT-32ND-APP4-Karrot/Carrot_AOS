package com.sumin.android.carrot_aos.presentation.review

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sumin.android.carrot_aos.R
import com.sumin.android.carrot_aos.data.model.response.ReviewResponse
import com.sumin.android.carrot_aos.databinding.ItemReviewButtonBinding
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
    private lateinit var sellerInfo: ReviewResponse.Writer
    private val context = context

    class ReviewCardViewHolder(
        private val binding: ItemReviewCardBinding,
        private val seller: ReviewResponse.Writer,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ReviewResponse.Review, viewType: Int) {
            when (viewType) {
                VIEW_TYPE_MINT -> binding.tvItemReviewTitle.text =
                    "${seller.nickname}님에게\n따뜻한 후기를 보냈어요."

                VIEW_TYPE_LIGHT_YELLOW -> {
                    with(binding) {
                        tvItemReviewTitle.text = "${seller.nickname}님이 보낸\n 따뜻한 후기가 도착했어요."
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

    class MyMannerViewHolder(
        private val binding: ItemReviewButtonBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_BUTTON -> {
                val binding = ItemReviewButtonBinding.inflate(inflater, parent, false)
                MyMannerViewHolder(binding)
            }

            else -> {
                val binding = ItemReviewCardBinding.inflate(inflater, parent, false)
                ReviewCardViewHolder(binding, sellerInfo, context)
            }
        }
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
            currentList.size - 1 -> VIEW_TYPE_BUTTON
            else -> VIEW_TYPE_LIGHT_YELLOW
        }
    }

    fun setSellerInfo(seller: ReviewResponse.Writer) {
        this.sellerInfo = seller
    }

    companion object {
        const val VIEW_TYPE_MINT = 0
        const val VIEW_TYPE_LIGHT_YELLOW = 1
        const val VIEW_TYPE_BUTTON = 2
    }
}