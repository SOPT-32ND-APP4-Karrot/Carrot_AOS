package com.sumin.android.carrot_aos.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.sumin.android.carrot_aos.R
import com.sumin.android.carrot_aos.databinding.FragmentHomeBinding
import com.sumin.android.carrot_aos.presentation.UiState
import com.sumin.android.carrot_aos.presentation.base.BindingFragment
import com.sumin.android.carrot_aos.presentation.sale.SaleActivity
import com.sumin.android.carrot_aos.util.extension.showSnackbar

class HomeFragment : BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val adapter = HomeAdapter(::navigateToSaleWith, requireContext())
        binding.rvHome.adapter = adapter
        adapter.setHomeList(viewModel.homeList)
    }

//    private fun addObservers(adapter: HomeAdapter) {
//        viewModel.homeResult.observe(viewLifecycleOwner) {
//            adapter.submitList(it.data)
//        }
//        viewModel.result.observe(viewLifecycleOwner) {
//            when(it) {
//                UiState.Success -> binding.root.showSnackbar("성공")
//                UiState.Failure -> binding.root.showSnackbar("실패")
//                UiState.Error -> binding.root.showSnackbar("에러")
//            }
//        }
//    }

    private fun navigateToSaleWith(id: Int, price: String) {
        val intent = Intent(requireContext(), SaleActivity::class.java).apply {
            putExtra("itemId", id)
            putExtra("itemPrice", price)
        }
        startActivity(intent)
    }
}
