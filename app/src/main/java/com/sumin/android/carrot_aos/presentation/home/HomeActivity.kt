package com.sumin.android.carrot_aos.presentation.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sumin.android.carrot_aos.R
import com.sumin.android.carrot_aos.databinding.ActivityHomeBinding
import com.sumin.android.carrot_aos.presentation.base.BindingActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.bnvMain.itemIconTintList = null
    }
}