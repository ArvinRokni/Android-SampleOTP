package com.fanap.sampleotp.data.repository

import androidx.lifecycle.MutableLiveData
import com.fanap.sampleotp.data.callback.SimpleCallback
import com.fanap.sampleotp.data.model.NetworkState
import com.fanap.sampleotp.data.repository.abs.GeneralRepository

class VerifyRepository(state: MutableLiveData<NetworkState>):
    GeneralRepository<Boolean>(SimpleCallback(state))