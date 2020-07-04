package com.jalanesia.mytrip.data.auth


import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("address")
    var address: String?,
    @SerializedName("city_id")
    var cityId: Int?,
    @SerializedName("city_name")
    var cityName: String?,
    @SerializedName("company_id")
    var companyId: Int?,
    @SerializedName("company_name")
    var companyName: String?,
    @SerializedName("country_id")
    var countryId: Int?,
    @SerializedName("country_name")
    var countryName: String?,
    @SerializedName("created_at")
    var createdAt: String?,
    @SerializedName("created_by")
    var createdBy: Int?,
    @SerializedName("created_by_name")
    var createdByName: String?,
    @SerializedName("description")
    var description: String?,
    @SerializedName("district_id")
    var districtId: Int?,
    @SerializedName("district_name")
    var districtName: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("full_name")
    var fullName: String?,
    @SerializedName("id")
    var id: Int?,
    @SerializedName("otp")
    var otp: String?,
    @SerializedName("password")
    var password: String?,
    @SerializedName("phone")
    var phone: String?,
    @SerializedName("state_id")
    var stateId: Int?,
    @SerializedName("state_name")
    var stateName: String?,
    @SerializedName("status")
    var status: Int?,
    @SerializedName("updated_at")
    var updatedAt: String?,
    @SerializedName("updated_by")
    var updatedBy: Int?,
    @SerializedName("updated_by_name")
    var updatedByName: String?,
    @SerializedName("user_type")
    var userType: Int?,
    @SerializedName("username")
    var username: String?,
    @SerializedName("verification_code")
    var verificationCode: String?,
    @SerializedName("verified")
    var verified: Int?
)