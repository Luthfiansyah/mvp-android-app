package com.jalanesia.mytrip.data.auth

import com.google.gson.annotations.SerializedName

data class RegisterRequest (
    @SerializedName("fullname")
    var fullname: String,

    @SerializedName("phone")
    var phone: String,

    @SerializedName("email")
    var email: String,

    @SerializedName("password")
    var password: String

)