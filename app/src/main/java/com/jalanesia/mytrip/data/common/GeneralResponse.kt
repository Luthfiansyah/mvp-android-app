package com.jalanesia.mytrip.data.common


import com.google.gson.annotations.SerializedName

data class GeneralResponse(
    @SerializedName("response_code")
    var responseCode: Int?,
    @SerializedName("response_message")
    var responseMessage: String?,
    @SerializedName("response_status")
    var responseStatus: Boolean?,
    @SerializedName("response_timestamp")
    var responseTimestamp: String?
)