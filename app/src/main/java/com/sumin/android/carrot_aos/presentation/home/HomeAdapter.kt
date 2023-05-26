package com.sumin.android.carrot_aos.presentation.home

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumin.android.carrot_aos.data.model.response.HomeResponse
import com.sumin.android.carrot_aos.databinding.ItemHomeBinding
import java.text.DecimalFormat

class HomeAdapter(
    private val navigateToSale: (Int, String) -> Unit,
    context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private var homeList: List<HomeResponse.HomeData> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemHomeBinding.inflate(inflater, parent, false)
        return HomeViewHolder(navigateToSale, binding)
    }

    override fun getItemCount() = homeList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeViewHolder) holder.onBind(homeList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setHomeList(list: List<HomeResponse.HomeData>) {
        this.homeList = list.toList()
        notifyDataSetChanged()
    }
}

//class HomeAdapter(
//    private val navigateToSale: (Int, String) -> Unit,
//    context: Context
//) : ListAdapter<HomeResponse.HomeData, RecyclerView.ViewHolder>(diffUtil) {
//    private val inflater by lazy { LayoutInflater.from(context) }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val binding = ItemHomeBinding.inflate(inflater, parent, false)
//        return HomeViewHolder(navigateToSale, binding)
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        if (holder is HomeViewHolder) holder.onBind(currentList[position])
//    }
//
//    companion object {
//        val diffUtil = object : DiffUtil.ItemCallback<HomeResponse.HomeData>() {
//            override fun areItemsTheSame(
//                oldItem: HomeResponse.HomeData,
//                newItem: HomeResponse.HomeData,
//            ): Boolean {
//                return oldItem.saleId == newItem.saleId
//            }
//
//            override fun areContentsTheSame(
//                oldItem: HomeResponse.HomeData,
//                newItem: HomeResponse.HomeData,
//            ): Boolean {
//                return oldItem == newItem
//            }
//        }
//    }
//}

class HomeViewHolder(
    private val navigateToSale: (Int, String) -> Unit,
    private val binding: ItemHomeBinding,
) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: HomeResponse.HomeData) {
        binding.ivHomeItem.load(data.saleImgUrl)
        binding.tvHomeItemContent.text = data.title
        binding.tvHomeItemWhere.text = data.location
        binding.tvHomeItemReupload.visibility = toggleVisibility(data.isUpdated)
        binding.tvHomeItemTime.text = data.time
        binding.tvHomeItemPrice.text = formatPrice(data.price)
        binding.ivHomeItemLike.visibility = toggleVisibility(data.likeCount == 0)
        binding.ivHomeItemLike.isActivated = data.isCheckLike
        binding.tvHomeItemLike.visibility = toggleVisibility(data.likeCount == 0)
        binding.tvHomeItemLike.text = data.likeCount.toString()
        binding.ivHomeItemDown.visibility = toggleVisibility(data.isDiscount)
        binding.tvHomeItemDown.visibility = toggleVisibility(data.isDiscount)
        binding.layoutHomeItem.setOnClickListener {
            navigateToSale(data.saleId, formatPrice(data.price))
        }
    }

    private fun toggleVisibility(status: Boolean): Int {
        return when (status) {
            true -> View.VISIBLE
            else -> View.GONE
        }
    }

    private fun formatPrice(price: Int): String {
        val priceFormat = DecimalFormat("#,###")
        return "${priceFormat.format(price)}원"
    }
}