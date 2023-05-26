package com.sumin.android.carrot_aos.presentation.home

import androidx.lifecycle.ViewModel
import com.sumin.android.carrot_aos.data.model.response.HomeResponse

class HomeViewModel : ViewModel() {
    val homeList = listOf(
        HomeResponse.HomeData(
            saleId = 1,
            title = "동교동 이웃 dd님에게만 보이는 순간이동 포털이 열렸어요",
            saleImgUrl = "https://carrotbucket32.s3.ap-northeast-2.amazonaws.com/e47bd937-6831-4561-b7fa-042399477606-sale1.webp",
            location = "서강동",
            time = "2023. 5. 19. 오후 2:52:58",
            isUpdated = false,
            price = 10000,
            isDiscount = true,
            likeCount = 0,
            isCheckLike = false
        ),
        HomeResponse.HomeData(
            saleId = 2,
            title = "동교동 이웃 dd님에게만 보이는 순간이동 포털이 열렸어요",
            saleImgUrl = "https://carrotbucket32.s3.ap-northeast-2.amazonaws.com/e47bd937-6831-4561-b7fa-042399477606-sale1.webp",
            location = "서강동",
            time = "2023. 5. 19. 오후 2:52:58",
            isUpdated = false,
            price = 10000,
            isDiscount = true,
            likeCount = 0,
            isCheckLike = false
        ),
        HomeResponse.HomeData(
            saleId = 3,
            title = "동교동 이웃 dd님에게만 보이는 순간이동 포털이 열렸어요",
            saleImgUrl = "https://carrotbucket32.s3.ap-northeast-2.amazonaws.com/e47bd937-6831-4561-b7fa-042399477606-sale1.webp",
            location = "서강동",
            time = "2023. 5. 19. 오후 2:52:58",
            isUpdated = false,
            price = 10000,
            isDiscount = true,
            likeCount = 0,
            isCheckLike = false
        ),
        HomeResponse.HomeData(
            saleId = 4,
            title = "동교동 이웃 dd님에게만 보이는 순간이동 포털이 열렸어요",
            saleImgUrl = "https://carrotbucket32.s3.ap-northeast-2.amazonaws.com/e47bd937-6831-4561-b7fa-042399477606-sale1.webp",
            location = "서강동",
            time = "2023. 5. 19. 오후 2:52:58",
            isUpdated = false,
            price = 10000,
            isDiscount = true,
            likeCount = 0,
            isCheckLike = false
        ),
        HomeResponse.HomeData(
            saleId = 5,
            title = "동교동 이웃 dd님에게만 보이는 순간이동 포털이 열렸어요",
            saleImgUrl = "https://carrotbucket32.s3.ap-northeast-2.amazonaws.com/e47bd937-6831-4561-b7fa-042399477606-sale1.webp",
            location = "서강동",
            time = "2023. 5. 19. 오후 2:52:58",
            isUpdated = false,
            price = 10000,
            isDiscount = true,
            likeCount = 0,
            isCheckLike = false
        ),
        HomeResponse.HomeData(
            saleId = 6,
            title = "동교동 이웃 dd님에게만 보이는 순간이동 포털이 열렸어요",
            saleImgUrl = "https://carrotbucket32.s3.ap-northeast-2.amazonaws.com/e47bd937-6831-4561-b7fa-042399477606-sale1.webp",
            location = "서강동",
            time = "2023. 5. 19. 오후 2:52:58",
            isUpdated = false,
            price = 10000,
            isDiscount = true,
            likeCount = 0,
            isCheckLike = false
        ),
        HomeResponse.HomeData(
            saleId = 7,
            title = "동교동 이웃 dd님에게만 보이는 순간이동 포털이 열렸어요",
            saleImgUrl = "https://carrotbucket32.s3.ap-northeast-2.amazonaws.com/e47bd937-6831-4561-b7fa-042399477606-sale1.webp",
            location = "서강동",
            time = "2023. 5. 19. 오후 2:52:58",
            isUpdated = false,
            price = 10000,
            isDiscount = true,
            likeCount = 0,
            isCheckLike = false
        ),
        HomeResponse.HomeData(
            saleId = 8,
            title = "동교동 이웃 dd님에게만 보이는 순간이동 포털이 열렸어요",
            saleImgUrl = "https://carrotbucket32.s3.ap-northeast-2.amazonaws.com/e47bd937-6831-4561-b7fa-042399477606-sale1.webp",
            location = "서강동",
            time = "2023. 5. 19. 오후 2:52:58",
            isUpdated = false,
            price = 10000,
            isDiscount = true,
            likeCount = 0,
            isCheckLike = false
        ),
    )
//    private val homeService = ServicePool.homeService
//
//    private val _homeResult = MutableLiveData<HomeResponse>()
//    val homeResult: LiveData<HomeResponse>
//        get() = _homeResult
//    private val _result = MutableLiveData<UiState>()
//    val result: LiveData<UiState>
//        get() = _result
//
//    fun getHomeList() {
//        homeService.getHomeList()
//            .enqueue(object : Callback<HomeResponse> {
//                override fun onResponse(
//                    call: Call<HomeResponse>,
//                    response: Response<HomeResponse>
//                ) {
//                    if (response.isSuccessful) {
//                        _result.value = UiState.Success
//                        _homeResult.value = response.body()
//                    } else {
//                        _result.value = UiState.Failure
//                    }
//                }
//
//                override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
//                    _result.value = UiState.Error
//                }
//
//            })
//    }

}