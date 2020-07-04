package com.jalanesia.mytrip.data.auth


import com.google.gson.annotations.SerializedName

data class AuthResult(
    @SerializedName("expired_at")
    var expiredAt: Int?,
    @SerializedName("token")
    var token: String?,
    @SerializedName("user_info")
    var userInfo: UserInfo?
)