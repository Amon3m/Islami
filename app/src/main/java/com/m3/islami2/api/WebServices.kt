package com.m3.islami2.api

import com.m3.islami2.model.RadioResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface WebServices  {

    @GET("radios?language=ar")
    fun getRadioChannels():Call<RadioResponse>
}