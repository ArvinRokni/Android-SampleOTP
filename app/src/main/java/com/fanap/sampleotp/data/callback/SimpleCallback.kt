package com.fanap.sampleotp.data.callback

import androidx.lifecycle.MutableLiveData
import com.fanap.sampleotp.data.model.NetworkState

class SimpleCallback(var liveObject: MutableLiveData<NetworkState>) :
    RequestCallback<Boolean> {

    override fun onRequestSuccess(result: Boolean?) {
        liveObject.value =  NetworkState.success()
    }

    override fun onRequestFailed(message: String?) {
        liveObject.value = NetworkState.faied(message)
    }
}