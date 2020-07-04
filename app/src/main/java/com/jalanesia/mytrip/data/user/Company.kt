package com.jalanesia.mytrip.data.user


import com.google.gson.annotations.SerializedName

data class Company(
    @SerializedName("bs")
    var bs: String?,
    @SerializedName("catchPhrase")
    var catchPhrase: String?,
    @SerializedName("name")
    var name: String?
)