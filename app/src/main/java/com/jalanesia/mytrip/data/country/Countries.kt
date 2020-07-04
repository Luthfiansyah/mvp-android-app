package com.jalanesia.mytrip.data.country


import com.google.gson.annotations.SerializedName
import com.jalanesia.mytrip.data.common.GeneralResponse
import com.jalanesia.mytrip.data.common.Pagination

data class Countries(
    @SerializedName("general_response")
    var generalResponse: GeneralResponse?,
    @SerializedName("pagination")
    var pagination: Pagination?,
    @SerializedName("result")
    var result: List<Country>?
)