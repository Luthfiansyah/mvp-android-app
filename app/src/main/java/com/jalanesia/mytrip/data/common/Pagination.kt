package com.jalanesia.mytrip.data.common


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("current_page")
    var currentPage: Int?,
    @SerializedName("from")
    var from: Int?,
    @SerializedName("last_page")
    var lastPage: Int?,
    @SerializedName("per_page")
    var perPage: Int?,
    @SerializedName("to")
    var to: Int?,
    @SerializedName("total")
    var total: Int?
)