package com.fanap.sampleotp.ui.login.identity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.fanap.sampleotp.data.api.ApiInterface
import com.fanap.sampleotp.data.model.srv.IdentitySrv
import com.fanap.sampleotp.data.model.NetworkState
import com.fanap.sampleotp.data.repository.IdentityRepository

class IdentityViewModel : ViewModel() {

    val networkState: MutableLiveData<NetworkState>
    private val repository: IdentityRepository
    private val api: ApiInterface

    init {
        networkState = MutableLiveData()
        repository = IdentityRepository(networkState)
        api = ApiClient.getClient().create(ApiInterface::class.java)
    }

    fun submitIdentity(identity: String) {
        networkState.value = NetworkState.loading()
        repository.request(api.submitIdentity(IdentitySrv(identity)))
    }
}
