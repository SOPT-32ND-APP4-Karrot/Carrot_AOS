package com.sumin.android.carrot_aos.presentation.chat

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sumin.android.carrot_aos.R
import com.sumin.android.carrot_aos.data.model.response.ChatResponse
import com.sumin.android.carrot_aos.databinding.ActivityChatBinding
import com.sumin.android.carrot_aos.util.binding.BindingAdapter.loadImage

class ChatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChatBinding
    private val viewModel by viewModels<ChatViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.connectChatOnline(1)
        setChatResultObserver()

        ivChatAppBarArrowleftClickListener()
    }

    private fun setChatResultObserver() {
        viewModel.chatResult.observe(this) { chatResponse ->
            setAppBarView(chatResponse)
            connectChatAdapter(chatResponse.data.chatMessageList, chatResponse.data.seller)
        }
    }

    private fun setAppBarView(chatResponse: ChatResponse) {
        with(binding) {
            tvChatAppBarUsername.text = chatResponse.data.seller.nickname
            ivChatExtendedAppBarSaleImg.loadImage(chatResponse.data.sale.saleImgUrl)
            tvChatExtendedAppBarStatus.text = chatResponse.data.sale.status
            tvChatExtendedAppBarTitle.text = chatResponse.data.sale.title
            tvChatExtendedAppBarPrice.text = "${chatResponse.data.sale.price}원"
            tvChatExtendedAppBarIsSuggest.text =
                if (chatResponse.data.sale.isSuggest) getString(R.string.chat_price_suggestion_available) else getString(
                    R.string.chat_price_suggestion_unavailable
                )
        }
    }

    private fun connectChatAdapter(
        chatMessageList: List<ChatResponse.ChatMessage>,
        seller: ChatResponse.Seller
    ) {
        val chatAdapter = ChatAdapter(this)
        chatAdapter.setSellerInfo(seller)
        chatAdapter.submitList(chatMessageList)
        binding.rvChatChatting.adapter = chatAdapter
    }

    private fun ivChatAppBarArrowleftClickListener() {
        binding.ivChatAppBarArrowleft.setOnClickListener {
            finish()
        }
    }
}