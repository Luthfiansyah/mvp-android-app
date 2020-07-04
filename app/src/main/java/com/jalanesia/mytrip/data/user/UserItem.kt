package com.jalanesia.mytrip.data.user


import com.google.gson.annotations.SerializedName

data class UserItem(
    @SerializedName("address")
    var address: Address?,
    @SerializedName("company")
    var company: Company?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("username")
    var username: String?,
    @SerializedName("website")
    var website: String?
)