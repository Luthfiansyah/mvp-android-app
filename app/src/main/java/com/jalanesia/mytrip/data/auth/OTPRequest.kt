package com.jalanesia.mytrip.data.auth

import com.google.gson.annotations.SerializedName

data class OTPRequest (
    @SerializedName("username")
    var username: String,

    @SerializedName("password")
    var password: String
)