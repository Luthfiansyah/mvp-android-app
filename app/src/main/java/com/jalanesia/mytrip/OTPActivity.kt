package com.jalanesia.mytrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.jalanesia.mytrip.data.auth.LoginRequest
import com.jalanesia.mytrip.data.auth.LoginResponse
import com.jalanesia.mytrip.service.NetworkConfig
import com.jalanesia.mytrip.utils.Auth
import kotlinx.android.synthetic.main.activity_otp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OTPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        // CHECK USER IS LOGIN
        var auth = Auth()
        if (auth.isLogin(this)){
            setContentView(R.layout.activity_main)
        }

        val usernameValue=intent.getStringExtra("username")
        val passwordValue=intent.getStringExtra("password")
        val phoneText: TextView = findViewById(R.id.phoneText) as TextView

        phoneText.text = usernameValue

        btnLogin.setOnClickListener() {
            val otpCodeValue: String = inputOTPCode.text.toString()

            if (otpCodeValue.trim() == "") {
                Toast.makeText(this, "please input your otp code", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            NetworkConfig().getService()
            .login(LoginRequest(username = usernameValue, password = passwordValue, otp = otpCodeValue))
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@OTPActivity, "Communication Error, please try again", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<LoginResponse>,response: Response<LoginResponse>) {
                    val loginResponse = response.body()
                    if(response.code() == 200) {
                        if (response.body()?.generalResponse?.responseStatus == true) {
                            var auth = Auth()
                            auth.setSession(this@OTPActivity, response.body()?.authResult?.token.toString())
                            val intent = Intent(this@OTPActivity,MainActivity::class.java)
                            startActivity(intent)
                        }else {
                            Toast.makeText( this@OTPActivity, response.body()?.generalResponse?.responseMessage.toString(), Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this@OTPActivity, response.body()?.generalResponse?.responseMessage, Toast.LENGTH_LONG).show()
                    }
                }
            })
        }
    }
}