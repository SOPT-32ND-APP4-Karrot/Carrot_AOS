package com.sumin.android.carrot_aos.presentation.sale

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sumin.android.carrot_aos.data.model.response.SaleRecommendationResponse
import com.sumin.android.carrot_aos.databinding.ItemRecommendationBinding
import com.sumin.android.carrot_aos.util.binding.BindingAdapter.loadImage

class SaleRecommendationAdapter :
    ListAdapter<SaleRecommendationResponse.Data, SaleRecommendationAdapter.RecommendationViewHolder>(
        diffUtil
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendationViewHolder {
        val binding =
            ItemRecommendationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendationViewHolder(binding)
    }


    override fun onBindViewHolder(holder: RecommendationViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class RecommendationViewHolder(private val binding: ItemRecommendationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: SaleRecommendationResponse.Data) {
            binding.ivRecommendationImage.loadImage(item.saleImgUrl)
            binding.tvRecommendationSaletitle.text = item.title
            binding.tvRecommendationPrice.text = item.price.toString() + "원"
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<SaleRecommendationResponse.Data>() {
            override fun areItemsTheSame(
                oldItem: SaleRecommendationResponse.Data,
                newItem: SaleRecommendationResponse.Data
            ): Boolean {
                return oldItem.saleId == newItem.saleId
            }

            override fun areContentsTheSame(
                oldItem: SaleRecommendationResponse.Data,
                newItem: SaleRecommendationResponse.Data
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}