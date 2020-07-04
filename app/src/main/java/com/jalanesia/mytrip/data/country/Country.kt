package com.jalanesia.mytrip.data.country


import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("code")
    var code: String?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("created_by")
    var createdBy: Int?,
    @SerializedName("created_by_name")
    var createdByName: String?,
    @SerializedName("currency")
    var currency: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("latitude")
    var latitude: Int?,
    @SerializedName("longitude")
    var longitude: Int?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("status")
    var status: Int?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("updated_by")
    var updatedBy: Int?,
    @SerializedName("updated_by_name")
    var updatedByName: String?
)