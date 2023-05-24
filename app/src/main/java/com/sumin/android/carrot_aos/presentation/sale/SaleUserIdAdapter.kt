package com.sumin.android.carrot_aos.presentation.sale

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumin.android.carrot_aos.data.model.response.SaleUserIdResponse
import com.sumin.android.carrot_aos.databinding.ItemUseridBinding
import com.sumin.android.carrot_aos.util.binding.BindingAdapter.loadImage

class SaleUserIdAdapter: ListAdapter<SaleUserIdResponse.Data.Sale, SaleUserIdAdapter.useridViewHolder>(diffUtil) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): useridViewHolder {
        val binding = ItemUseridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return useridViewHolder(binding)
    }


    override fun onBindViewHolder(holder: useridViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class useridViewHolder(private val binding: ItemUseridBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: SaleUserIdResponse.Data.Sale) {
            binding.ivUseridSaleimg.loadImage(item.saleImgUrl)
            binding.tvUseridSaletitle.text = item.title
            binding.tvUseridPrice.text = item.price.toString()
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<SaleUserIdResponse.Data.Sale>() {
            override fun areItemsTheSame(oldItem: SaleUserIdResponse.Data.Sale, newItem: SaleUserIdResponse.Data.Sale): Boolean {
                return oldItem.saleId == newItem.saleId
            }

            override fun areContentsTheSame(oldItem: SaleUserIdResponse.Data.Sale, newItem: SaleUserIdResponse.Data.Sale): Boolean {
                return oldItem == newItem
            }
        }
    }
}