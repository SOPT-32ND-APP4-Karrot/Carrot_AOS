package com.sumin.android.carrot_aos.presentation.chat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.sumin.android.carrot_aos.data.model.response.ChatResponse
import com.sumin.android.carrot_aos.databinding.ItemChatLeftBinding
import com.sumin.android.carrot_aos.databinding.ItemChatRightBinding
import com.sumin.android.carrot_aos.util.extension.ItemDiffCallback
import com.sumin.android.carrot_aos.util.extension.changeTimeFormat

class ChatAdapter(context: Context) :
    ListAdapter<ChatResponse.ChatMessage, RecyclerView.ViewHolder>(
        ItemDiffCallback<ChatResponse.ChatMessage>(
            onContentsTheSame = { old, new -> old == new },
            onItemsTheSame = { old, new -> old == new }
        )
    ) {
    private val inflater by lazy { LayoutInflater.from(context) }
    private lateinit var sellerInfo: ChatResponse.Seller
    private lateinit var myInfo: ChatResponse.Writer

    class ChatRightViewHolder(
        private val binding: ItemChatRightBinding,
        private val seller: ChatResponse.Seller
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ChatResponse.ChatMessage, isTopSpace: Boolean) {
            with(binding) {
                tvChatRightText.text = data.content
                tvChatRightTime.text = changeTimeFormat(data.time)

                val announcementContent =
                    "<b>안내</b> ${seller.nickname}님과 거래 예약을 했어요. 당근페이에 가입하면 간편하게 송금할 수 있어요. <u>자세히 보기</u>"
                tvItemChatRightAnnouncementContent.text =
                    HtmlCompat.fromHtml(announcementContent, HtmlCompat.FROM_HTML_MODE_LEGACY)

                if (!data.hasKeyword) layoutChatRightAnnouncement.visibility = View.GONE
                if (isTopSpace) {
                    layoutChatRightTopSpace.visibility = View.GONE
                }
            }
        }
    }

    class ChatLeftViewHolder(
        private val binding: ItemChatLeftBinding,
        private val seller: ChatResponse.Seller
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ChatResponse.ChatMessage, isNoProfile: Boolean) {
            with(binding) {
                tvChatLeftText.text = data.content
                tvChatLeftTime.text = changeTimeFormat(data.time)
                if (seller.profileImgUrl != "기본이미지.png") ivChatLeftProfile.load(seller.profileImgUrl)

                val announcementContent =
                    "<b>안내</b> ${seller.nickname}님과 거래 예약을 했어요. 당근페이에 가입하면 간편하게 송금할 수 있어요. <u>자세히 보기</u>"
                tvItemChatLeftAnnouncementContent.text =
                    HtmlCompat.fromHtml(announcementContent, HtmlCompat.FROM_HTML_MODE_LEGACY)

                if (!data.hasKeyword) layoutChatLeftAnnouncement.visibility = View.GONE
                if (isNoProfile) {
                    ivChatLeftProfile.visibility = View.INVISIBLE
                    layoutChatLeftTopSpace.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_CHAT_RIGHT -> {
                val binding = ItemChatRightBinding.inflate(inflater, parent, false)
                ChatRightViewHolder(binding, sellerInfo)
            }

            else -> {
                val binding = ItemChatLeftBinding.inflate(inflater, parent, false)
                ChatLeftViewHolder(binding, sellerInfo)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ChatRightViewHolder -> holder.onBind(
                currentList[position],
                (position != 0) && (currentList[position].writer == currentList[position - 1].writer)
            )

            is ChatLeftViewHolder -> holder.onBind(
                currentList[position],
                (position != 0) && (currentList[position].writer == currentList[position - 1].writer)
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (currentList[position].writer.nickname) {
            sellerInfo.nickname -> VIEW_TYPE_CHAT_LEFT
            else -> {
                myInfo = currentList[position].writer
                VIEW_TYPE_CHAT_RIGHT
            }
        }
    }

    fun setSellerInfo(seller: ChatResponse.Seller) {
        this.sellerInfo = seller
    }

    fun addChatMessage(content: String, time: String) {
        val tempCurrentChatMessage = mutableListOf<ChatResponse.ChatMessage>()
        tempCurrentChatMessage.addAll(currentList)
        val newChatMessage = ChatResponse.ChatMessage(
            chatMessageId = currentList[currentList.size - 1].chatMessageId + 1,
            content = content,
            hasKeyword = false,
            time = time,
            writer = myInfo
        )
        tempCurrentChatMessage.add(newChatMessage)
        submitList(tempCurrentChatMessage)
    }

    companion object {
        const val VIEW_TYPE_CHAT_RIGHT = 0
        const val VIEW_TYPE_CHAT_LEFT = 1
    }
}