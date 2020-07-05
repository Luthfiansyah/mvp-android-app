package com.jalanesia.mytrip

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.jalanesia.mytrip.data.auth.LoginResponse
import com.jalanesia.mytrip.data.auth.OTPRequest
import com.jalanesia.mytrip.data.common.GeneralResponse
import com.jalanesia.mytrip.service.NetworkConfig
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // var sessionManager = SessionManager(this)

        btnLogin.setOnClickListener() {
            val usernameValue: String = inputUsername.text.toString()
            val passwordValue: String = inputPassword.text.toString()
            if (usernameValue.trim() == "") {
                Toast.makeText(this, "please input your username", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (passwordValue.trim() == "") {
                Toast.makeText(this, "please input your password", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            NetworkConfig().getService()
            .authOTP(OTPRequest(username = usernameValue, password = passwordValue))
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Communication Error, please try again", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    //Tulis code jika response sukses
                    if(response.code() == 200) {
                        if (response.body()?.generalResponse?.responseStatus == true) {
                            val intent = Intent(this@LoginActivity,OTPActivity::class.java)
                            intent.putExtra("username",usernameValue)
                            intent.putExtra("password",passwordValue)
                            startActivity(intent)
                        }
                    }else {
                        Toast.makeText( this@LoginActivity, response.body()?.generalResponse?.responseMessage.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            })
        }
    }
}
