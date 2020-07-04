package com.jalanesia.mytrip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jalanesia.mytrip.data.auth.OTPRequest
import com.jalanesia.mytrip.data.common.GeneralResponse
import com.jalanesia.mytrip.service.NetworkConfig
import kotlinx.android.synthetic.main.activity_otp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OTPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        var sessionManager = SessionManager(this)

//        btnLogin.setOnClickListener() {
//            val otpCodeValue: String = inputOTPCode.text.toString()
//
//            if (otpCodeValue.trim() == "") {
//                Toast.makeText(this, "please input your otp code", Toast.LENGTH_LONG).show()
//                return@setOnClickListener
//            }
//
//            NetworkConfig().getService()
//            .login(OTPRequest(username = usernameValue, password = passwordValue))
//            .enqueue(object : Callback<GeneralResponse> {
//                override fun onFailure(call: Call<GeneralResponse>, t: Throwable) {
//                    // Error logging in
//                }
//
//                override fun onResponse(
//                    call: Call<GeneralResponse>,
//                    response: Response<GeneralResponse>
//                ) {
//                    val loginResponse = response.body()
//
//                    if (loginResponse?.responseCode == 0 && loginResponse.responseStatus == true) {
//                        // sessionManager.saveAuthToken(loginResponse.authToken)
//                    } else {
//                        // Error logging in
//                    }
//                }
//            })
//        }
    }
}