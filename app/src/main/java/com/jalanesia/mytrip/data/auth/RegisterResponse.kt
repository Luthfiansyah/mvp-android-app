package com.jalanesia.mytrip.data.auth


import com.google.gson.annotations.SerializedName
import com.jalanesia.mytrip.data.common.GeneralResponse

data class RegisterResponse(
    @SerializedName("general_response")
    var generalResponse: GeneralResponse?,
    @SerializedName("result")
    var authResult: AuthResult?
)