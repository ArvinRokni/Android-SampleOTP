package com.fanap.sampleotp.ui.login.verify

import ApiClient
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fanap.sampleotp.data.api.ApiInterface
import com.fanap.sampleotp.data.model.NetworkState
import com.fanap.sampleotp.data.model.srv.VerifySrv
import com.fanap.sampleotp.data.repository.VerifyRepository

class VerifyViewModel : ViewModel() {

    val networkState: MutableLiveData<NetworkState>
    private val repository: VerifyRepository
    private val api: ApiInterface

    init {
        networkState = MutableLiveData()
        repository = VerifyRepository(networkState)
        api = ApiClient.getClient().create(ApiInterface::class.java)
    }

    fun submitVerify(verify: String) {
        networkState.value = NetworkState.loading()
        repository.request(api.verifyIdentity(VerifySrv(verify)))
    }
}
